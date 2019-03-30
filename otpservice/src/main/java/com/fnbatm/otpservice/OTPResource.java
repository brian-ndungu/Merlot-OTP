package com.fnbatm.otpservice;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("otp")
public class OTPResource {
	
	OTPRepo repo = new OTPRepo();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<OTPClient> getClients(){
		System.out.println("Fetching otp's...");
		return repo.getClients();
	}
	
	@POST
	@Path("initiateOTP")
	public OTPClient initiateOTP(OTPClient o) {
		System.out.println("Initiating OTP...");
		OTP curOTP=new OTP(o);
		curOTP.generateOTP(4);
		curOTP.setOTP();
		curOTP.sendOTP(true);
		return repo.create(curOTP.getClient());
	}
	
	@POST
	@Path("verifyOTP")
	public OTPClient verifyOTP(OTPClient o) {
		System.out.println("Verifying OTP...");
		repo.create(o);
		return o;
	}
	
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	public OTPClient getClient(){
//		System.out.println("Fetching otp...");
//		OTPClient o1 = new OTPClient("001");
//		o1.setOTP("1234");
//		o1.setStatusM("Correct");
//		o1.setStatus(true);
//		return o1;
//	}
//	@GET
//	@Path("cid/{clientid}")
//	@Produces(MediaType.APPLICATION_JSON)
//	public String getOTPStatus(@PathParam("clientid") String clientid) throws InterruptedException {
//		//CASE 1: Ideal Situation
//		OTPClient tempClient= new OTPClient(clientid);
//		OTP curOTP= new OTP(tempClient);
//		//OTP is generated
//		curOTP.setOTP("256");
//		//OTP is typed in
//		curOTP.setATMOTP("256");
//		tempClient= curOTP.verifyOTP(tempClient, true, true);
//		
//		//CASE 2: Incorrect OTP
////		OTPClient tempClient= new OTPClient(clientid);
////		OTP curOTP= new OTP(tempClient);
////		//OTP is generated
////		curOTP.generateOTP(5);
////		//OTP is generated
////		curOTP.setATMOTP("256");
////		tempClient= curOTP.verifyOTP(tempClient, true, true);
//		
//		//CASE 3: Notification Exception
////		OTPClient tempClient= new OTPClient(clientid);
////		OTP curOTP= new OTP(tempClient);
////		//OTP is generated
////		curOTP.generateOTP(5);
////		//OTP is generated
//////		curOTP.setATMOTP("256");
////		tempClient= curOTP.verifyOTP(tempClient, false, true);
//		
//		//CASE 4: ATMSimulation Exception
////		OTPClient tempClient= new OTPClient(clientid);
////		OTP curOTP= new OTP(tempClient);
////		//OTP is generated
////		curOTP.generateOTP(5);
////		//OTP is generated
////		curOTP.setATMOTP("256");
////		tempClient= curOTP.verifyOTP(tempClient, true, false);
//		
//		
//		return tempClient.statusMsg;
//	}
}
