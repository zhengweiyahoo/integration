package com.clock.2billingmethods;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.fortumo.android.Fortumo;
import com.fortumo.android.PaymentActivity;
import com.fortumo.android.PaymentRequestBuilder;
import com.fortumo.android.PaymentResponse;

public class Pay4stopwatch extends PaymentActivity 
{

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    // buy Points to use the Stop Watch
    PaymentRequestBuilder builder = new PaymentRequestBuilder();
    if (Wallet.isNook()) {
    	builder.setService("Clock", "in-app secret");
    	builder.setProductName("Clock_stopwatch_credit");
    }
    else
    {
    	builder.setService("Clock", "in-app secret");
    	builder.setProductName("Clock_stopwatch_op");
    }
    builder.setConsumable(true);
    builder.setDisplayString("200 Points");
    builder.setPriceAmount("2");
    builder.setPriceCurrency("USD");
    makePayment(builder.build());
      
  } 
  
  // Note the callback in PaymentStatusReceiver Class
  
}

