package com.fnbatm.otpservice;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class OTP {
	
	private OTPClient obj;
	private String otpcode;
	
	public OTP(OTPClient obj){
		this.obj=obj;
//		Client client=ClientBuilder.newClient();
    }
	
	public OTPClient getClient() {
		return obj;
	}
    /**Random Generator for the OTP  */
    public void generateOTP( int len ){
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
        otpcode=otp.toString();
//        otpcode="456";
    }

    public void setOTP() {
    	obj.setOtp(otpcode);
    }
    /** Communicate with Notification */
    public boolean sendOTP(boolean sent){
    	if(sent==true) {
    		obj.setStatusMsg("Sent to notification");
    		return true;
    	}else {
    		obj.setStatusMsg("Failure due to notification not being sent");
    		return false;
    	}
//    	WebTarget target = client.target("http://localhost:8080/rest/book/PHP");
//    	target.request(MediaType.APPLICATION_JSON).get();
    }
    
    private String getATMOTP() {
    	if(obj.getOtp()=="") {
    		String atmotp="456";
    		return atmotp;
    	}else
    		return obj.getOtp();
    }

    public void setATMOTP(String atmO) {
    	obj.setOtp(atmO);
    }
    /** Communicate with ATM 
     * @throws InterruptedException */
    public OTPClient verifyOTP(OTPClient obj, boolean sent, boolean received) throws InterruptedException{
    	if(sendOTP(sent)) {
	    	System.out.println("Waiting for input...");
	        
	        System.out.println();
	        System.out.println();
	        System.out.println();
	        System.out.println();
	        TimeUnit.SECONDS.sleep(5);
	        //recieves OTP obj
	        obj.setOtp(getATMOTP());
			  System.out.println("OTP from ATM recieved. Attempting verification.");
			  if(obj.getOtp()==otpcode)//otp verified
			  {
			    obj.setStatus(true);
			    obj.setStatusMsg("Verification Successful");
			  }
			  else if(obj.getOtp()==null)//otp 
			      {
			         obj.setStatus(false);
			        obj.setStatusMsg("Time Period Expired");
			  }
			  else if(obj.getOtp()!=otpcode)
		          {
		                obj.setStatus(false);
		                obj.setStatusMsg("Incorrect pin");
		          }
			  if(!sent) {
				  obj.setStatus(false);
				  obj.setStatusMsg("Notification transmission error");
			  }else if(!received) {
				  obj.setStatus(false);
				  obj.setStatusMsg("ATM OTP not received error");
			  }
    	}
    	return obj;
    }

}
