package com.clock.2billingmethods;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.fortumo.android.Fortumo;
import com.fortumo.android.PaymentActivity;
import com.fortumo.android.PaymentRequestBuilder;
import com.fortumo.android.PaymentResponse;

public class Pay4Upgrade extends PaymentActivity {

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    // Buy non-consumable billing product "Clock_Pro_Op, make one time payment to upgrade
    PaymentRequestBuilder builder = new PaymentRequestBuilder();
    if (Wallet.isNook()) {
    	builder.setService("Clock", "in-app secret");
    	builder.setProductName("Clock_Pro_credit");
    }
    else
    {
    	 builder.setService("Clock", "in-app secret");
    	 builder.setProductName("Clock_Pro_op");    	
    }
    builder.setConsumable(false);
    builder.setDisplayString("Clock Full License");
    builder.setPriceAmount("2");
    builder.setPriceCurrency("USD");
    makePayment(builder.build());
         
  } 
  
  // Note the callback in PaymentStatusReceiver Class
  
}

