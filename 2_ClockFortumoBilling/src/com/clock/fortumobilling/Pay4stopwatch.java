package com.clock.fortumobilling;

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

    // make one time payment to upgrade
    Fortumo.enablePaymentBroadcast(this, package com.clock.fortumobilling;.PAYMENT_BROADCAST_PERMISSION);
    PaymentRequestBuilder builder = new PaymentRequestBuilder();
    builder.setService("Clock", "in-app secret");
    builder.setDisplayString("Top up the Stop Watch Points");      // shown on user receipt
    builder.setProductName("Clock_Stopwatch_Op"); 
    builder.setConsumable(true);              // consumable items
    makePayment(builder.build()); 
     
  }
  
  // Note the callback in PaymentStatusReceiver Class
  
}

