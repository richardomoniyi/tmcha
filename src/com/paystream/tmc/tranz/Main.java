/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paystream.tmc.tranz;

import com.blacksilicon.netapps.nip.pojo.NESingleRequest;
import com.blacksilicon.netapps.nip.util.PayUtil;
import nfp.ssm.core.SSMLib;

/**
 *
 * @author thefavourofpraise
 */
public class Main {
    
    public static void main(String arg[]) {
        new Main().testRun2();
    }
    private void testRun2()
    {
        /*
        Netapps - 999275
        0051762787
999998 (code)
        */
        //-9220838217261427002
        NESingleRequest nsr = new NESingleRequest();
        nsr.setSessionId(PayUtil.generateSession("999998"));
        nsr.setChannelCode("1");
        nsr.setAccountNumber("0051762787");
        nsr.setDestinationInstitutionCode("999998");
        System.out.println(nsr.toXmlString());
        
    }
    private void testRun1()
    {
        

     SSMLib ssmlib=new SSMLib("/Users/thefavourofpraise/Documents/config/nippublic.key","/Users/thefavourofpraise/Documents/config/nipprivate.key");
     //ssmlib.generateKeyPair("netapps", "netphrase");
	 
    }

     //Method to Generate Public and Private keys
    public void generatePublicAndPrivateKeys()
    {
        SSMLib enc = new SSMLib("c:/NMRC_public.key", "c:/NMRC_private.key");
        enc.generateKeyPair("Any_user_name", "Any_password");
    }
    
    //How to encrypt a request
    public String encryptRequest(final String dataToEncrypt)
    {
        SSMLib enc = new SSMLib("c:/NMRC_public.key", "c:/NMRC_private.key");
        return enc.encryptMessage(dataToEncrypt);
    }    

    //How to decrypt a request    
    public String decryptRequest(final String dataToDecrypt)
    {
        SSMLib enc = new SSMLib("c:/nibss_public.key", "c:/NMRC_private.key");
        return enc.decryptFile(dataToDecrypt, "Password_Used_To_Generate_Key_Pair");
    }   
    
}
