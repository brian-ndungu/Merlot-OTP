package com.fnbatm.otpservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("otp")
public class OTPResource {
	
	@GET
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public String getOTP(JSON input) {
//		OTP curOtp= OTP();
		return "9728";
	}
	
}
