package com.team3.ict2105.InfoMed;

import android.animation.StateListAnimator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.os.Build;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by jerahmeelchua on 9/2/18.
 */

// TODO WRITE SPECIFIC ADAPTERS FOR DIFFERENT CARDS

//	https://stackoverflow.com/questions/41464629/expand-collapse-animation-in-cardview

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.MyViewHolder>{
	private String[] mDataset;

	// Provide a reference to the views for each data item
	// Complex data items may need more than one view per item, and
	// you provide access to all the views for a data item in a view holder
	public static class MyViewHolder extends RecyclerView.ViewHolder {
		public CardView mCardView;
		public TextView mTextView;
		public MyViewHolder(View v) {
			super(v);

			mCardView = (CardView) v.findViewById(R.id.card_view);
			mTextView = (TextView) v.findViewById(R.id.tv_text);
		}
	}

	// Provide a suitable constructor (depends on the kind of dataset)
	public TestAdapter(String[] myDataset) {
		mDataset = myDataset;
	}

	// Create new views (invoked by the layout manager)
	@Override
	public TestAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
	                                                 int viewType) {
		// create a new view
		View v = LayoutInflater.from(parent.getContext())
				.inflate(R.layout.card_item, parent, false);
		// set the view's size, margins, paddings and layout parameters
		MyViewHolder vh = new MyViewHolder(v);
		return vh;
	}

	@Override
	public void onBindViewHolder(MyViewHolder holder, final int position) {
		holder.mTextView.setText(mDataset[position]);
		animate(holder.mCardView, position);
		holder.mCardView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				String currentValue = mDataset[position];
				Log.d("CardView", "CardView Clicked: " + currentValue);
			}
		});
	}

	@Override
	public int getItemCount() {
		return mDataset.length;
	}

	private void animate(View view, final int pos) {
		view.animate().cancel();
		view.setTranslationY(100);
		view.setAlpha(0);
		view.animate().alpha(1.0f).translationY(0).setDuration(300).setStartDelay(pos * 40);
	}
}
