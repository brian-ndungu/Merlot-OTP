package com.fnbatm.otpservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("otp")
public class OTPResource {
	
	@GET
	@Path("cid/{clientid}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getOTPStatus(@PathParam("clientid") String clientid) throws InterruptedException {
		//CASE 1: Ideal Situation
//		OTPClient tempClient= new OTPClient(clientid);
//		OTP curOTP= new OTP(tempClient);
//		//OTP is generated
//		curOTP.setOTP("256");
//		//OTP is typed in
//		curOTP.setATMOTP("256");
//		tempClient= curOTP.verifyOTP(tempClient, true);
		
		//CASE 2: Incorrect OTP
//		OTPClient tempClient= new OTPClient(clientid);
//		OTP curOTP= new OTP(tempClient);
//		//OTP is generated
//		curOTP.generateOTP(5);
//		//OTP is generated
//		curOTP.setATMOTP("256");
//		tempClient= curOTP.verifyOTP(tempClient, true, true);
		
		//CASE 3: Notification Exception
//		OTPClient tempClient= new OTPClient(clientid);
//		OTP curOTP= new OTP(tempClient);
//		//OTP is generated
//		curOTP.generateOTP(5);
//		//OTP is generated
////		curOTP.setATMOTP("256");
//		tempClient= curOTP.verifyOTP(tempClient, false, true);
		
		//CASE 4: ATMSimulation Exception
		OTPClient tempClient= new OTPClient(clientid);
		OTP curOTP= new OTP(tempClient);
		//OTP is generated
		curOTP.generateOTP(5);
		//OTP is generated
		curOTP.setATMOTP("256");
		tempClient= curOTP.verifyOTP(tempClient, true, false);
		
		
		return tempClient.statusMsg;
	}
}
