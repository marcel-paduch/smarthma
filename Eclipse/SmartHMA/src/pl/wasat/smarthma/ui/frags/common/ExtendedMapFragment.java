package pl.wasat.smarthma.ui.frags.common;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.PolygonOptions;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Picasso.LoadedFrom;
import com.squareup.picasso.Target;
import com.squareup.picasso.Transformation;

import java.util.ArrayList;
import java.util.List;

import pl.wasat.smarthma.R;
import pl.wasat.smarthma.interfaces.OnBaseMapFragmentPublicListener;
import pl.wasat.smarthma.model.om.Footprint;
import pl.wasat.smarthma.model.om.Pos;
import pl.wasat.smarthma.ui.frags.base.BaseMapFragment;

/**
 * A simple {@link Fragment} subclass. Activities that contain this fragment
 * must implement the
 * interface to handle interaction events. Use the
 * {@link ExtendedMapFragment#newInstance} factory method to create an instance
 * of this fragment.
 */
public class ExtendedMapFragment extends Fragment implements
        OnBaseMapFragmentPublicListener, Target, Transformation,
        OnSeekBarChangeListener {

    private BaseMapFragment baseMapFragment;
    private GoogleMap mMap;
    private GroundOverlay groundOverlay;
    private SeekBar seekBarOpacity;

    private BitmapDescriptor qLookImage;

    private static final int BEARING_LEVEL_VALUE = 0;
    private static final int START_OPACITY = 25;

    private OnExtendedMapFragmentListener mListener;

    private LatLng qLookCenter;
    private float qLookWidth;
    private float qLookHeight;
    private float qLookBearing;

    /**
     * Use this factory method to create a new instance of this fragment using
     * the provided parameters.
     *
     * @return A new instance of fragment MapExtendedFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ExtendedMapFragment newInstance() {
        return new ExtendedMapFragment();
    }

    public ExtendedMapFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_map_extended,
                container, false);

        seekBarOpacity = (SeekBar) rootView
                .findViewById(R.id.seekBar_opacity_overlay);
        seekBarOpacity.setOnSeekBarChangeListener(this);

        return rootView;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        FragmentManager fm = getChildFragmentManager();
        baseMapFragment = (BaseMapFragment) fm
                .findFragmentById(R.id.frag_support_map_base);
        if (baseMapFragment == null) {
            baseMapFragment = BaseMapFragment.newInstance(this);
            fm.beginTransaction()
                    .replace(R.id.frag_support_map_base, baseMapFragment)
                    .commit();
        }

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnExtendedMapFragmentListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnExtendedMapFragmentListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated to
     * the activity and potentially other fragments contained in that activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnExtendedMapFragmentListener {
        public void onMapReady();
    }

    private void buildFootprintBounds(List<LatLng> footprintPoints) {
        LatLngBounds.Builder boundsBuilder = new LatLngBounds.Builder();
        for (int j = 0; j < footprintPoints.size(); j++) {
            boundsBuilder.include(footprintPoints.get(j));
        }
        baseMapFragment.setTargetBounds(boundsBuilder.build());
    }

    /**
     * @param footprint
     */
    public void showFootPrints(Footprint footprint) {
        ArrayList<LatLng> footprintPoints = extractLatLngFootprint(footprint);
        buildFootprintBounds(footprintPoints);
        drawFootprint(footprintPoints);
    }

    private ArrayList<LatLng> extractLatLngFootprint(Footprint footprint) {
        List<Pos> footprintPosList = footprint.getMultiExtentOf()
                .getMultiSurface().getSurfaceMembers().getPolygon()
                .getExterior().getLinearRing().getPosList();
        if (footprintPosList.isEmpty()) {
            String posStr = footprint.getMultiExtentOf().getMultiSurface()
                    .getSurfaceMembers().getPolygon().getExterior()
                    .getLinearRing().getPosString().getPointsString();
            footprintPosList = footprint.getMultiExtentOf().getMultiSurface()
                    .getSurfaceMembers().getPolygon().getExterior()
                    .getLinearRing().setPosList(posStr);
        }

        ArrayList<LatLng> footprintPoints = new ArrayList<>();
        float prevBearing = 0;

        for (int i = 0; i < footprintPosList.size() - 1; i++) {
            double currLat = footprintPosList.get(i).getLatLng().latitude;
            double currLng = footprintPosList.get(i).getLatLng().longitude;
            double nextLat = footprintPosList.get(i + 1).getLatLng().latitude;
            double nextLng = footprintPosList.get(i + 1).getLatLng().longitude;

            float[] results = new float[3];

            Location.distanceBetween(currLat, currLng, nextLat, nextLng,
                    results);

            if (Math.abs(results[2] - prevBearing) >= BEARING_LEVEL_VALUE) {
                footprintPoints.add(footprintPosList.get(i).getLatLng());
            }
            prevBearing = results[2];
        }

        return footprintPoints;
    }

    private void drawFootprint(ArrayList<LatLng> footprintPoints) {
        if (footprintPoints.size() > 0) {
            PolygonOptions rectOptions = new PolygonOptions();
            rectOptions.addAll(footprintPoints);
            rectOptions.strokeColor(Color.HSVToColor(new float[]{
                    179 + (9 * 4), 1, 1})); // change 4 to variable;
            rectOptions.strokeWidth(4);
            rectOptions.geodesic(true);
            rectOptions.zIndex(1);
            mMap.addPolygon(rectOptions);
        }
    }

    private void calcQuickLookParams(Footprint footprint,
                                     ArrayList<LatLng> footprintPoints) {
        double oneLat = footprintPoints.get(0).latitude;
        double oneLng = footprintPoints.get(0).longitude;
        double twoLat = footprintPoints.get(1).latitude;
        double twoLng = footprintPoints.get(1).longitude;
        double fourLat = footprintPoints.get(3).latitude;
        double fourLng = footprintPoints.get(3).longitude;
        float[] results = new float[3];

        qLookCenter = footprint.getCenterOf().getPoint().getPos().getLatLng();

        Location.distanceBetween(oneLat, oneLng, twoLat, twoLng, results);
        qLookHeight = results[0];

        Location.distanceBetween(oneLat, oneLng, fourLat, fourLng, results);
        qLookWidth = results[0];
        qLookBearing = ((results[1] + results[2]) / 2) - 90;

    }

    public void showQuicklookOnMap(String url, Footprint footprint) {

        ArrayList<LatLng> footprintPoints = extractLatLngFootprint(footprint);

        buildFootprintBounds(footprintPoints);

        calcQuickLookParams(footprint, footprintPoints);
        drawFootprint(footprintPoints);

        Target quicklookTarget = this;
        Picasso.with(getActivity())
                .load(url)
                .transform(this)
                .into(quicklookTarget);
    }

/*	// decodes image and scales it to reduce memory consumption
    private Bitmap decodeFile(File f) {
		try {
			// Decode image size
			BitmapFactory.Options o = new BitmapFactory.Options();
			o.inJustDecodeBounds = true;
			BitmapFactory.decodeStream(new FileInputStream(f), null, o);

			// The new size we want to scale to
			final int REQUIRED_SIZE = 70;

			// Find the correct scale value. It should be the power of 2.
			int scale = 1;
			while (o.outWidth / scale / 2 >= REQUIRED_SIZE
					&& o.outHeight / scale / 2 >= REQUIRED_SIZE)
				scale *= 2;

			// Decode with inSampleSize
			BitmapFactory.Options o2 = new BitmapFactory.Options();
			o2.inSampleSize = scale;
			return BitmapFactory.decodeStream(new FileInputStream(f), null, o2);
		} catch (FileNotFoundException e) {
		}
		return null;
	}*/

    @Override
    public void onBaseSupportMapPublicReady() {
        mMap = baseMapFragment.getMap();
        if (mListener != null) {
            mListener.onMapReady();
        }

    }

    @Override
    public void onPrepareLoad(Drawable arg0) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onBitmapLoaded(Bitmap bitmap, LoadedFrom arg1) {
        qLookImage = BitmapDescriptorFactory.fromBitmap(bitmap);

        GroundOverlayOptions groundOverlayOpt = new GroundOverlayOptions()
                .image(qLookImage)
                .position(qLookCenter, qLookWidth, qLookHeight)
                .bearing(qLookBearing).zIndex(2)
                .transparency((float) START_OPACITY / 100);

        groundOverlay = mMap.addGroundOverlay(groundOverlayOpt);

        seekBarOpacity.setProgress(START_OPACITY);
    }

    @Override
    public void onBitmapFailed(Drawable arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress,
                                  boolean fromUser) {
        if (groundOverlay != null) {
            int opacity = seekBarOpacity.getProgress();
            groundOverlay.remove();

            GroundOverlayOptions groundOverlayOpt = new GroundOverlayOptions()
                    .image(qLookImage)
                    .position(qLookCenter, qLookWidth, qLookHeight)
                    .bearing(qLookBearing).zIndex(2)
                    .transparency((float) opacity / 100);

            groundOverlay = mMap.addGroundOverlay(groundOverlayOpt);
        }

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        // TODO Auto-generated method stub

    }

    @Override
    public String key() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Bitmap transform(Bitmap source) {
        //int size = Math.min(source.getWidth(), source.getHeight());
        int x = (int) ((source.getWidth()) / 1.5);
        int y = (int) ((source.getHeight()) / 1.5);
        Bitmap result = Bitmap.createScaledBitmap(source, x, y, false);
        if (result != source) {
            source.recycle();
        }
        return result;
    }

}
