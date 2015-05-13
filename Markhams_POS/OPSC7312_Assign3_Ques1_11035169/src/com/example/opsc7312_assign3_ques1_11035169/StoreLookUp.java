package com.example.opsc7312_assign3_ques1_11035169;

import android.webkit.WebSettings; 
import android.webkit.WebView;
import android.os.Bundle;
import android.app.Activity;
import android.widget.Toast;
import android.webkit.WebViewClient;

public class StoreLookUp extends Activity{
	
	//this is a web service declaration that will display the google map web page
	WebView wv;
	WebSettings webSettings;
	
	//This method loads the GUI onto the welcome activity
		@Override
		protected void onCreate(Bundle savedInstanceState) { 
			super.onCreate(savedInstanceState);
			setContentView(R.layout.store_look_up);
			
			//getting the settings for web viewer
			//creating zooming controls 
			wv = (WebView) findViewById(R.id.webview1);
			webSettings = wv.getSettings();
			webSettings.setBuiltInZoomControls(true);
			wv.setWebViewClient(new Callback());
			wv.loadUrl("http://www.googlemaps.com");
			wv.setWebViewClient(new Callback());
		}
		
		private class Callback extends WebViewClient {
			@Override
			public boolean shouldOverrideUrlLoading(
				WebView view, String url) {
				return(false);
			}
		}
		
		//Method to show output for error messages
		public void DisplayOutput(String output){
			Toast.makeText(getBaseContext(), output,Toast.LENGTH_SHORT).show();
		}

}
