package pl.wasat.smarthma.ui.frags.browse;

import pl.wasat.smarthma.R;
import pl.wasat.smarthma.SmartHMApplication;
import pl.wasat.smarthma.adapter.CollectionsGroupListAdapter;
import pl.wasat.smarthma.model.CollectionsGroup.List;
import pl.wasat.smarthma.services.SmartHmaHttpSpiceService;
import pl.wasat.smarthma.utils.http.ExplainDocRequest;
import pl.wasat.smarthma.utils.xml.XMLParser;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

import com.octo.android.robospice.SpiceManager;
import com.octo.android.robospice.UncachedSpiceService;
import com.octo.android.robospice.persistence.exception.SpiceException;
import com.octo.android.robospice.request.listener.RequestListener;
import com.octo.android.robospice.spicelist.okhttp.OkHttpBitmapSpiceManager;

public class CollectionsGroupListFragment extends Fragment implements
		RequestListener<String> {

	/***
	 * With {@link UncachedSpiceService} there is no cache management. Remember
	 * to declare it in AndroidManifest.xml
	 */

	private OkHttpBitmapSpiceManager spiceManagerBinary = new OkHttpBitmapSpiceManager();

	private SpiceManager spiceManager = new SpiceManager(
			SmartHmaHttpSpiceService.class);

	private ListView collectionsGroupListView;
	private View loadingView;

    @Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRetainInstance(true);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_collections_group_list,
				container, false);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		initUIList();
	}

	@Override
	public void onStart() {
		super.onStart();
		spiceManager.start(getActivity());
		spiceManagerBinary.start(getActivity());

		loadListSmartHMA();
	}

	@Override
	public void onStop() {
		if (spiceManager.isStarted()) {
			spiceManager.shouldStop();
		}
		if (spiceManagerBinary.isStarted()) {
			spiceManagerBinary.shouldStop();
		}
		super.onStop();
	}

	private void updateEOListViewContent(List collectGrList) {
        CollectionsGroupListAdapter collectionsGroupListAdapter = new CollectionsGroupListAdapter(
                getActivity(), spiceManagerBinary, collectGrList);
		collectionsGroupListView.setAdapter(collectionsGroupListAdapter);

		loadingView.setVisibility(View.GONE);
		collectionsGroupListView.setVisibility(View.VISIBLE);

		// Click event for single list row
		collectionsGroupListView
				.setOnItemClickListener(new OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> parent, View view,
							int position, long id) {
						loadCollectionsList(position);
					}
				});
	}

	private void loadCollectionsList(int listPosition) {
		CollectionsListFragment collectionsListFragment = CollectionsListFragment
				.newInstance(listPosition);
		getActivity().getSupportFragmentManager().beginTransaction()
				.replace(R.id.activity_base_list_container, collectionsListFragment).addToBackStack("CollectionsListFragment")
				.commit();
	}

	/**
	 * 
	 */
	private void loadListSmartHMA() {
		getActivity().setProgressBarIndeterminateVisibility(true);
		spiceManager.execute(new ExplainDocRequest(), this);

	}

	// --------------------------------------------------------------------------------------------
	// PRIVATE
	// --------------------------------------------------------------------------------------------

	private void initUIList() {
		collectionsGroupListView = (ListView) getView().findViewById(
				R.id.listview_collections_group);
		loadingView = getView().findViewById(R.id.loading_layout);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.octo.android.robospice.request.listener.RequestListener#onRequestFailure
	 * (com.octo.android.robospice.persistence.exception.SpiceException)
	 */
	@Override
	public void onRequestFailure(SpiceException arg0) {
		getActivity().setProgressBarIndeterminateVisibility(false);
		Toast.makeText(getActivity(), "Impossible to get the list of users",
				Toast.LENGTH_SHORT).show();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.octo.android.robospice.request.listener.RequestListener#onRequestSuccess
	 * (java.lang.Object)
	 */
	@Override
	public void onRequestSuccess(String result) {
		getActivity().setProgressBarIndeterminateVisibility(false);
		XMLParser xmlResult = new XMLParser();
		xmlResult.parseXml(result);
		updateEOListViewContent(SmartHMApplication.GlobalEODataList);

	}
}
