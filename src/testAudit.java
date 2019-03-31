/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

/**
 *
 * @author User
 */

public class testAudit {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        
        OTP node=new OTP();
        OTPclient cl=new OTPclient();
        cl.otp=node.generateOTP(4).toString();
        node.otpcode=cl.otp;
        node.verifyOTP(cl);
        System.out.println(cl.statusMsg);
    }
    
}
