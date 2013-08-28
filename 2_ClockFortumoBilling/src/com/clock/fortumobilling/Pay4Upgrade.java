package com.clock.fortumobilling;

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
    Fortumo.enablePaymentBroadcast(this, com.clock.fortumobilling.PAYMENT_BROADCAST_PERMISSION);
    PaymentRequestBuilder builder = new PaymentRequestBuilder();
    builder.setService("Clock", "in-app secret");
    builder.setDisplayString("Clock Full License");      // shown on user receipt
    builder.setProductName("Clock_Pro_Op");  // non-consumable purchases are restored using this value
    builder.setConsumable(false);              // non-consumable items can be later restore
    makePayment(builder.build()); 
     
  } 
  
  // Note the callback in PaymentStatusReceiver Class
  
}

