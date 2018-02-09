package com.team3.ict2105.myapplication;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class HomeFragment extends Fragment {
	private static final String TAG = HomeFragment.class.getSimpleName();

	public HomeFragment(){
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
				"Home two",
				"Home three",
				"Home four",
				"Home five",
				"Home six",
				"Home one",
				"Home two",
				"Home three",
				"Home four",
				"Home five",
				"Home six",
				"Home seven"});
		rv.setAdapter(adapter);

		LinearLayoutManager llm = new LinearLayoutManager(getActivity());
		rv.setLayoutManager(llm);

		return rootView;
	}
}
