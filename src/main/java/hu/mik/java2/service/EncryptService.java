package hu.mik.java2.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.jboss.crypto.CryptoUtil;

public class EncryptService {
	public EncryptService(){
		
	}
	
	public String encrypt(String password){
		String hashedPW;
/*		byte[] passwordInBytes=null;
		try {
			passwordInBytes = password.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		byte[] hashedPW=null;
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			hashedPW=md.digest(passwordInBytes);
			System.out.println(hashedPW.toString());
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hashedPW.toString();*/
		hashedPW=CryptoUtil.createPasswordHash("MD5", "Base64", null, null, password);
		
		return hashedPW;
	}
}
