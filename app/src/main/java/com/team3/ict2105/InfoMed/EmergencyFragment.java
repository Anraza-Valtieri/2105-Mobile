package com.team3.ict2105.InfoMed;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class EmergencyFragment extends Fragment {
	private static final String TAG = EmergencyFragment.class.getSimpleName();

	public EmergencyFragment(){
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
		View rootView = inflater.inflate(R.layout.blankfragment, container, false);

		RecyclerView rv = (RecyclerView) rootView.findViewById(R.id.rv_recycler_view);
		rv.setHasFixedSize(true);
		TestAdapter adapter = new TestAdapter(new String[]{
				getString(R.string.cardview_contents),
				"Emergency two",
				"Emergency three",
				"Emergency four",
				"Emergency five",
				"Emergency six",
				"Emergency one",
				"Emergency two",
				"Emergency three",
				"Emergency four",
				"Emergency five",
				"Emergency six",
				"Emergency seven"});
		rv.setAdapter(adapter);

		LinearLayoutManager llm = new LinearLayoutManager(getActivity());
		rv.setLayoutManager(llm);

		return rootView;
	}
}
