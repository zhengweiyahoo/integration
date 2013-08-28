package com.clock.2billingmethods;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.os.Bundle;

import com.fortumo.android.Fortumo;

public class PaymentStatusReceiver extends BroadcastReceiver {

	public void onReceive(Context context, Intent intent) {
		Bundle extras = intent.getExtras();

		int billingStatus = extras.getInt("billing_status");
		
		if (billingStatus == Fortumo.MESSAGE_STATUS_BILLED) {

			String serviceId = extras.getString("service_id");
			String productName = extras.getString("product_name");

			if (serviceId = "Clock") && (productName = "Clock_Pro_credit") 
			{

				Wallet.topupPoints(200);
				// update the Points in UI and inform user that Stop
			}
			
			if (serviceId = "Clock") && (productName = "Clock_stopwatch_credit") 
			{

				Wallet.setFullLicenseClock();	
			    // change the clock text color to Red and remove the Upgrade button 
			}
			
			if (serviceId = "Clock") && (productName = "Clock_Pro_op") 
			{

				Wallet.topupPoints(200);
				// update the Points in UI and inform user that Stop watch can be used
			}
			
			if (serviceId = "Clock") && (productName = "Clock_stopwatch_op") 
			{

				Wallet.setFullLicenseClock();	
			    // change the clock text color to Red and remove the Upgrade button 
			}
		}
	}
}
