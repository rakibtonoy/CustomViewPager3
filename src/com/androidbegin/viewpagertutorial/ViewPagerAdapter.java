package com.androidbegin.viewpagertutorial;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
 
public class ViewPagerAdapter extends PagerAdapter {
	// Declare Variables
	Context context;
	String[] rank_dyn;
	int[] flag;
	LayoutInflater inflater;
 //1
	public ViewPagerAdapter(Context context, String[] rank, int[] flag) {
		this.context = context;
		this.rank_dyn = rank;
		this.flag = flag;
	}
 //2
	@Override
	public int getCount() {
		return rank_dyn.length;
	}
 
	@Override
	public boolean isViewFromObject(View view, Object object) {
		return view == ((LinearLayout) object);
	}
 //3
	@Override
	public Object instantiateItem(ViewGroup container, int position) {
 
		// Declare Variables
		TextView txtrank;
		ImageView imgflag;
 
		inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View itemView = inflater.inflate(R.layout.viewpager_item, container,
				false);		

		// Locate the ImageView in viewpager_item.xml
		imgflag = (ImageView) itemView.findViewById(R.id.flag);
		txtrank=(TextView) itemView.findViewById(R.id.ranklabel);
		// Capture position and set to the ImageView
		txtrank.setText(rank_dyn[position]);
		imgflag.setImageResource(flag[position]);
 
		// Add viewpager_item.xml to ViewPager
		((ViewPager) container).addView(itemView);
 
		return itemView;
	}
 
	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		// Remove viewpager_item.xml from ViewPager
		((ViewPager) container).removeView((LinearLayout) object);
 
	}
}