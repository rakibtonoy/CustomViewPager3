package com.androidbegin.viewpagertutorial;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;
 
public class MainActivity extends Activity {
 
	// Declare Variables
	int counter=0;
	
	ViewPager viewPager;
	PagerAdapter adapter;
	String[] rank;
	int[] flag;
   ImageButton prev_IB;
   ImageButton next_IB;
   
   public void previous(int prev_page){
	   
	   if (counter>0) {
		   counter--;
		   viewPager.setCurrentItem(counter);
		
	} else {
		counter=9;
		viewPager.setCurrentItem(counter);

	}
	      
	   } 
   
   public void next(int next_page){
	   if (counter<9) {
		   counter++;
		   viewPager.setCurrentItem(counter);
		
	} else {
		counter=0;
		viewPager.setCurrentItem(counter);

	}
	      
	   } 
   
   
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Get the view from viewpager_main.xml
		setContentView(R.layout.viewpager_main);
 
		// Generate sample data
		rank = new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
 
		flag = new int[] { R.drawable.china, R.drawable.india,
				R.drawable.unitedstates, R.drawable.indonesia,
				R.drawable.brazil, R.drawable.pakistan, R.drawable.nigeria,
				R.drawable.bangladesh, R.drawable.russia, R.drawable.japan };
		
		
		prev_IB=(ImageButton) findViewById(R.id.prev_IB);
		prev_IB.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				previous(0);				/*
				Toast.makeText(getApplicationContext(),"this is my Toast message!!! =)", 
		                Toast.LENGTH_SHORT).show();
				if(viewPager!=null)
					viewPager.setCurrentItem(9, true);*/
			}
		});
		
		next_IB=(ImageButton) findViewById(R.id.next_IB);
		next_IB.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				next(0);
				// TODO Auto-generated method stub
				/*Toast.makeText(getApplicationContext(),"this is my Next message!!! =)", 
		                Toast.LENGTH_SHORT).show();
				if(viewPager!=null)
					viewPager.setCurrentItem(0, true);*/
			}
		});
 
		// Locate the ViewPager in viewpager_main.xml
		viewPager = (ViewPager) findViewById(R.id.pager);
		// Pass results to ViewPagerAdapter Class
		adapter = new ViewPagerAdapter(MainActivity.this, rank, flag);
		viewPager.setCurrentItem(1);
		// Binds the Adapter to the ViewPager
		viewPager.setAdapter(adapter);
 
	}
}