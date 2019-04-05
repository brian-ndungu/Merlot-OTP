package com.fnbatm.otpservice;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class OTPClient {
    private String clientID="";
    private boolean status=false;
    private String statusMsg="";
    private String otp=null;
    
//    public OTPClient(String clientID) {
//    	this.clientID=clientID;
//    }
    
    public String getClientID() {
		return clientID;
	}

	public void setClientID(String clientID) {
		this.clientID = clientID;
	}

	public String getStatusMsg() {
		return statusMsg;
	}

	public void setStatusMsg(String statusMsg) {
		this.statusMsg = statusMsg;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public boolean isStatus() {
		return status;
	}
	
	public void setStatus(boolean status) {
		this.status=status;
	}
	
}
