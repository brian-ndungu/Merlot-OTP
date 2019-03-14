package com.fnbatm.otpservice;

import java.util.Random;

public class OTP {
	
	private String ClientID;
	private String status;
	
	public void OTP(String ClientID){
		this.ClientID=ClientID;
    }

    /**Random Generator for the OTP  */
    private char[] generateOTP( int len ){
        // Using numeric values 
        String numbers = "0123456789"; 
  
        // Using random method 
        Random rndm_method = new Random(); 
  
        char[] otp = new char[len]; 
  
        for (int i = 0; i < len; i++) 
        { 
            // Use of charAt() method : to get character value 
            // Use of nextInt() as it is scanning the value as int 
            otp[i] = numbers.charAt(rndm_method.nextInt(numbers.length())); 
        } 
        return otp;
    }

    /** Communicate with Notification */
    private void sendOTP(){

    }

    /** Communicate with ATM */
    private void verifyOTP(){

    }

    public String getAuthenticationStatus(){
    	return null;
    }
}
