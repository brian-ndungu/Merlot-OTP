package com.fnbatm.otpservice;

import java.util.ArrayList;
import java.util.List;

public class OTPRepo {
	List<OTPClient> clients;
	public OTPRepo() {
		clients = new ArrayList<>();
		OTPClient o1 = new OTPClient();
		o1.setClientID("001");
		o1.setOtp("1234");
		o1.setStatusMsg("Correct");
		o1.setStatus(true);
		
		clients = new ArrayList<>();
		OTPClient o2 = new OTPClient();
		o2.setClientID("002");
		o2.setOtp("456");
		o2.setStatusMsg("Pin Incorrect");
		o2.setStatus(false);
		
		clients.add(o1);
		clients.add(o2);
	}
	
	public List<OTPClient> getClients(){
		return clients;
	}
	public OTPClient getClient(String cid) {
		for(OTPClient o : clients) {
			if(o.getClientID()==cid)
				return o;
		}
		return null;
	}

	public OTPClient create(OTPClient o) {
		clients.add(o);
		return o;
	}
}
