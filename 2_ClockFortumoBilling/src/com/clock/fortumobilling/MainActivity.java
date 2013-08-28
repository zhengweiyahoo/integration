package com.clock.fortumobilling;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.widget.DigitalClock;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends Activity {
	
	private Button button1_upgrade;
	private Button button2_stopwatch;

	// variables for Display in Stop Watch feature 
	private Boolean stop_watch_on = false;
	private long elapsed;
	private long startTime = 0L;
	private Handler customHandler = new Handler();

	// handle the Upgrade, Purchase Points, Consume Points	
	public void addListenerOnButton() {
		if Wallet.isFullLicenseClock() {
	       change the clock text color to Red and remove the Upgrade button
		}   
	
		// Handle Upgrade button
		button1_upgrade = (Button) findViewById(R.id.button1_upgrade); 
		button1_upgrade.setOnClickListener(new View.OnClickListener() {

		@Override
		public void onClick(View arg0) {
			TextView clockText=(TextView) findViewById(R.id.digitalClock1);

			// Fortuma integration: pay the Upgrade 	
			pay4Upgrade = New Pay4Upgrade();
		}
		});
	

		// Handle Stop Watch buttons
		button2_stopwatch = (Button) findViewById(R.id.button2_stopwatch); 
		button2_stopwatch.setOnClickListener(new View.OnClickListener() {

		@Override
		// Turn on / off the Stop Watch
		public void onClick(View arg0) {
				if (stop_watch_on)
				{ 	
					// pay 1 Point for using the stop watch and display current available Points
					if Wallet.spendPoints(1)
					{
						// Turn off the stop watch counter and change the display text on the button
						stop_watch_on = false;
						button2_stopwatch.setText("Turn On the Stop Watch");
						customHandler.removeCallbacks(updateTimerThread);
					}
					else
					{
						// no enough Point to use the Start Watch, promote the user to purchase Points - Fortuma billing integration
						pay4stopwatch = New Pay4stopwatch();
					}					
				}
				else
				{	
					
					// Turn on the stop watch counter and start to display text on the button
					stop_watch_on = true;
				    button2_stopwatch.setText("Turn Off the Stop Watch");   
				    startTime = System.currentTimeMillis();
				    customHandler.postDelayed(updateTimerThread, 0);
				    
				}  
		}
		});	
}

// display the clock time when the Stop Watch is turn On
private Runnable updateTimerThread = new Runnable() 
{	 
  		  
}
