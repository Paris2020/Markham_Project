package com.example.opsc7312_assign3_ques1_11035169;

import android.app.Fragment;   
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class WelcomeFragment2 extends Fragment implements OnClickListener{
	
	//Declare a button to enter the Markhham wesite
	Button btnFashion,btnViewPrices;
	
	//This method will load the GUI of welcome_fragment2 of the welcome activity
	@Override
	public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
		
		//Inflate the layout for this fragment
		View v = inflater.inflate(R.layout.welcome_fragment2, container, false);
		
		//instantiate the button objects
		btnFashion = (Button)v.findViewById(R.id.btnFashion);
		btnFashion.setOnClickListener(this);
		
		btnViewPrices = (Button)v.findViewById(R.id.btnViewPrices);
		btnViewPrices.setOnClickListener(this);
		return v;
	}
	
	//This button event will direct the user to the website
	public void onClick(View v){
		switch(v.getId()){
		
		case R.id.btnFashion:
			getActivity().startActivity(new Intent("com.example.opsc7312_assign3_ques1_11035169.Catalogue"));
			break;
		case R.id.btnViewPrices:
			getActivity().startActivity(new Intent("com.example.opsc7312_assign3_ques1_11035169.ViewPrices"));
			break;
		}
	}

}
