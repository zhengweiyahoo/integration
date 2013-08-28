//---------------------------------------
package com.example.textview_ex;

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
	
private Button button1;
private Button button2;
private Boolean stop_watch_on = false;
private long elapsed;
private long startTime = 0L;
private Handler customHandler = new Handler();

public void addListenerOnButton() {
		
	
		button2 = (Button) findViewById(R.id.button2); 
		button2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				if (stop_watch_on)
				{ 	
					stop_watch_on = false;
					button2.setText("Turn On the Stop Watch");
					customHandler.removeCallbacks(updateTimerThread);
				}
				else
				{	
					stop_watch_on = true;
				    button2.setText("Turn Off the Stop Watch");
				  
				    //elapsed = ((System.currentTimeMillis() - startTime) / 1000);
				    //String display = String.format("%02d:%02d:%02d", elapsed / 3600, (elapsed % 3600) / 60, (elapsed % 60));
				    //TextView secondCount = (TextView) findViewById(R.id.textView2); 
				    //secondCount.setText(display);
				    
				    
				    startTime = System.currentTimeMillis();
				    customHandler.postDelayed(updateTimerThread, 0);
				    
				}  
			}
		});
	
		button1 = (Button) findViewById(R.id.button1); 
		button1.setOnClickListener(new View.OnClickListener() {
 
			@Override
			public void onClick(View arg0) {
			  TextView clockText=(TextView) findViewById(R.id.digitalClock1);
			  clockText.setTextColor(Color.GREEN);
			  
			  ViewGroup layout = (ViewGroup) button1.getParent();
			  if(null!=layout) //for safety only  as you are doing onClick
			    layout.removeView(button1);
			}
		});
		
}

private Runnable updateTimerThread = new Runnable() {	 
		   public void run() {	 
	            elapsed  = System.currentTimeMillis() - startTime;
	            String display = Long.toString(elapsed);
			    TextView secondCount = (TextView) findViewById(R.id.textView2); 
			    secondCount.setText("Stop Watch Counts:" + display);	           
	            customHandler.postDelayed(this, 0);
	        }	 
};
	

@Override
public void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);

final DigitalClock dc=(DigitalClock) findViewById(R.id.digitalClock1);
final TextView tv=(TextView) findViewById(R.id.textView1);

addListenerOnButton();
dc.setClickable(true);
dc.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
//TODO Auto-generated method stub
//tv.setText(dc.getText().toString());
//tv.setTextColor(Color.GREEN);

TextView clockText=(TextView) findViewById(R.id.digitalClock1);
clockText.setTextColor(Color.RED);

}
});
}

@Override
public boolean onCreateOptionsMenu(Menu menu) {
getMenuInflater().inflate(R.menu.main, menu);
return true;
}
}

