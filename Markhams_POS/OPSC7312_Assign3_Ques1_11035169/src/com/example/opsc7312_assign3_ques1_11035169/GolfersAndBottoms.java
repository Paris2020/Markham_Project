package com.example.opsc7312_assign3_ques1_11035169;

import android.os.Bundle;       
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;

public class GolfersAndBottoms extends Activity {

	//the images to display
	Integer[] imageIDs = {
			R.drawable.pic17,
			R.drawable.pic18,
			R.drawable.pic19,
			R.drawable.pic20,
			R.drawable.pic5,
			R.drawable.pic6,
			R.drawable.pic7,
			R.drawable.pic8
	};
	
	//This method loads the GUI onto the welcome activity
		@Override
		protected void onCreate(Bundle savedInstanceState) { 
			super.onCreate(savedInstanceState);
			setContentView(R.layout.access_under);
			
			//
			Gallery gallery = (Gallery) findViewById(R.id.gallery4);
			gallery.setAdapter(new ImageAdapter(this));
			gallery.setOnItemClickListener(new OnItemClickListener()
			{
				public void onItemClick(AdapterView parent, View v,
				int position, long id)
				{
					Toast.makeText(getBaseContext(),"Item: " + (position + 1) + " selected",Toast.LENGTH_SHORT).show();
					//---display the images selected---
					ImageView imageView =(ImageView) findViewById(R.id.image4);
					imageView.setImageResource(imageIDs[position]);
				}
			});
		}
		
		public class ImageAdapter extends BaseAdapter
		{
			Context context;
			int itemBackground;
			public ImageAdapter(Context c)
			{
				context = c;
				//setting the style
				TypedArray a = obtainStyledAttributes(R.styleable.Gallery4);
				itemBackground = a.getResourceId(R.styleable.Gallery4_android_galleryItemBackground,0);
				a.recycle();
			}
			
			//returns the number of images
			public int getCount() {
				return imageIDs.length;
			}
			
			//returns the item
			public Object getItem(int position) {
				return position;
			}
			
			//returns the ID of an item
			public long getItemId(int position) {
				return position;
			}
			
			//returns an ImageView view
			public View getView(int position, View convertView,ViewGroup parent) {
				ImageView imageView;
				if (convertView == null) {
					imageView = new ImageView(context);
					imageView.setImageResource(imageIDs[position]);
					imageView.setScaleType(
					ImageView.ScaleType.FIT_XY);
					imageView.setLayoutParams(new Gallery.LayoutParams(150, 150));
				}
				else{
					imageView = (ImageView) convertView;
				}
					imageView.setBackgroundResource(itemBackground);
					return imageView;
				}
			}
}
