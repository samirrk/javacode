package com.samirrk.encrypt;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;

public class DESMain 
{

	private static final String ALGO = "DESede";
    private static final byte[] keyValue = 
            new byte[] { 'T', 'h', 'e', 'B', 'e', 's', 't','Z', 
    					'o', 'o', 'm', 'i', 'f', 'i', 'e','S', 
    					'e', 'c', 'r','e', 't', 'K', 'e', 'y' };

    /**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		try 
		{
	        Key key = new SecretKeySpec(keyValue, ALGO);
			//Key key = KeyGenerator.getInstance(ALGO).generateKey();
	        Cipher c = Cipher.getInstance(ALGO);
	        doEncDec("4870", key, c);
	        doEncDec("1", key, c);
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	public static void doEncDec(String data, Key key, Cipher c) throws Exception
	{
		String enc = encrypt(data, key, c);
		System.out.println(enc);
		System.out.println(decrypt(enc, key, c));
	}

	public static String encrypt(String Data, Key key, Cipher c) throws Exception  
	{
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encVal = c.doFinal(Data.getBytes());
        //String encryptedValue = new BASE64Encoder().encode(encVal);
        //String encryptedValue = Base64.encodeBase64String(encVal);
        String encryptedValue = Hex.encodeHexString(encVal);
        return encryptedValue;
    }

    public static String decrypt(String encryptedData, Key key, Cipher c) throws Exception 
    {
        c.init(Cipher.DECRYPT_MODE, key);
        //byte[] decodedValue = encryptedData.getBytes();
        //byte[] decodedValue = Base64.decodeBase64(encryptedData);
        byte[] decodedValue = Hex.decodeHex(encryptedData.toCharArray());
        byte[] decValue = c.doFinal(decodedValue);
        String decryptedValue = new String(decValue);
        return decryptedValue;
    }
}
