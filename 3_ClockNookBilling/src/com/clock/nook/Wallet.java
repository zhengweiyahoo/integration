package com.clock.nook;

public class Wallet {

    public Wallet() {
    	
    }
    
    public void topupPoints(int p) {
    	// add p Points to Wallet
    }
    
    public Boolean spendPoints(int p) {
    	// take p Points from Wallet
    	// return True if success, return False if no enough money
    }  
    
    public void setFullLicenseClock() {
    	// store Full License flag to application preferences    	
    }
    
    public Boolean isFullLicenseClock() {
    	if (user has Full License flag in application preferences) OR (user has brought the "Clock_Pro_Op" product, called API getNonConsumablePaymentStatus)
    	   {	  
    		   setFullLicenseClock(); 
    		   return True;
    	   }	   
    	   else
    		   return False;
    	}
    }  
    
}
