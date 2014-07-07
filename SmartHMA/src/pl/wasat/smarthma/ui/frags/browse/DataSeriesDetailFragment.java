package pl.wasat.smarthma.ui.frags.browse;

import pl.wasat.smarthma.R;
import pl.wasat.smarthma.database.EoDbAdapter;
import pl.wasat.smarthma.model.feed.Entry;
import pl.wasat.smarthma.ui.frags.MapSearchFragment;
import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link android.support.v4.app.Fragment} subclass. Activities that
 * contain this fragment must implement the
 * {@link DataSeriesDetailFragment.OnDataSeriesDetailFragmentInteractionListener}
 * interface to handle interaction events. Use the
 * {@link DataSeriesDetailFragment#newInstance} factory method to create an
 * instance of this fragment.
 * 
 */
public class DataSeriesDetailFragment extends Fragment {
	// TODO: Rename parameter arguments, choose names that match
	// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
	public static final String ARG_ITEM_ID = "item_id";

	private OnDataSeriesDetailFragmentInteractionListener mListener;
	private Entry displayedEntry;
	private EoDbAdapter db;
	
	private Button searchButton;

	/**
	 * Use this factory method to create a new instance of this fragment using
	 * the provided parameters.
	 * 
	 * @param param1
	 *            Parameter 1.
	 * @param param2
	 *            Parameter 2.
	 * @return A new instance of fragment DataSeriesDetailFragment.
	 */
	// TODO: Rename and change types and number of parameters
	public static DataSeriesDetailFragment newInstance(String param1,
			String param2) {
		DataSeriesDetailFragment fragment = new DataSeriesDetailFragment();
		Bundle args = new Bundle();
		fragment.setArguments(args);
		return fragment;
	}

	public DataSeriesDetailFragment() {
		setHasOptionsMenu(true);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (getArguments() != null) {
		}

		db = new EoDbAdapter(getActivity());
		if (getArguments().containsKey(Entry.KEY_RSS_ENTRY)) {
			displayedEntry = (Entry) getArguments().getSerializable(
					Entry.KEY_RSS_ENTRY);
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_dataseries_detail,
				container, false);
		if (displayedEntry != null) {
			final String title = displayedEntry.getTitle();
			final String pubDate = "This EO data ware published: "
					+ displayedEntry.getPublished() + " and updated: "
					+ displayedEntry.getUpdated();

			String content = displayedEntry.getSummary();
			((TextView) rootView.findViewById(R.id.dataseries_name))
					.setText(title);
			((TextView) rootView.findViewById(R.id.dataseries_dates))
					.setText(pubDate);
			WebView detailWebView = (WebView) rootView
					.findViewById(R.id.dataseries_detail);
			detailWebView.loadData(content, "text/html", "UTF-8");

			searchButton = (Button) rootView
					.findViewById(R.id.ds_detail_button_search_product);
			searchButton.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					loadSearchParameters(title, pubDate);

				}

			});
		}
		return rootView;
	}

	// TODO: Rename method, update argument and hook method into UI event
	public void onButtonPressed(Uri uri) {
		if (mListener != null) {
			mListener.onDataSeriesDetailFragmentInteraction(uri);
		}
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		try {
			mListener = (OnDataSeriesDetailFragmentInteractionListener) activity;
		} catch (ClassCastException e) {
			throw new ClassCastException(activity.toString()
					+ " must implement OnFragmentInteractionListener");
		}
	}

	@Override
	public void onDetach() {
		super.onDetach();
		mListener = null;
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		inflater.inflate(R.menu.menu_detail_twopane, menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.actionbar_saveoffline) {
			Toast.makeText(getActivity().getApplicationContext(),
					"This metadata has been saved offline.", Toast.LENGTH_LONG)
					.show();
			return true;
		}
		else {
			return super.onOptionsItemSelected(item);
		}

	}

	/**
	 * This interface must be implemented by activities that contain this
	 * fragment to allow an interaction in this fragment to be communicated to
	 * the activity and potentially other fragments contained in that activity.
	 * <p>
	 * See the Android Training lesson <a href=
	 * "http://developer.android.com/training/basics/fragments/communicating.html"
	 * >Communicating with Other Fragments</a> for more information.
	 */
	public interface OnDataSeriesDetailFragmentInteractionListener {
		// TODO: Update argument type and name
		public void onDataSeriesDetailFragmentInteraction(Uri uri);
	}

	private void loadSearchParameters(String title, String pubDate) {

		MapSearchFragment mapSearchFragment = MapSearchFragment.newInstance(
				null, null);
		getActivity().getSupportFragmentManager().beginTransaction()
				.replace(R.id.dataseries_detail_container, mapSearchFragment)
				.addToBackStack("MapSearchFragment").commit();

		CollectionItemRightFragment collectionItemRightFragment = CollectionItemRightFragment
				.newInstance(displayedEntry, title, pubDate);
		getActivity()
				.getSupportFragmentManager()
				.beginTransaction()
				.add(R.id.dataseries_list,
						collectionItemRightFragment,"CollectionItemRightFragment")
				.addToBackStack("CollectionItemRightFragment").commit();

	}
	
}