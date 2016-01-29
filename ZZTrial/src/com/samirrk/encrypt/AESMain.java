package com.samirrk.encrypt;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;

public class AESMain 
{

	private static final String ALGO = "AES";
    private static final byte[] keyValue = 
        new byte[] { 'T', 'h', 'e', 'B', 'e', 's', 't','S', 'e', 'c', 'r','e', 't', 'K', 'e', 'y' };
    
    /**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		try 
		{
			System.out.println(encrypt("1234"));
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static String encrypt(String Data) throws Exception 
	{
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encVal = c.doFinal(Data.getBytes());
        //String encryptedValue = new BASE64Encoder().encode(encVal);
        //String encryptedValue = new String(encVal);
        String encryptedValue = Hex.encodeHexString(encVal);
        return encryptedValue;
    }

    public static String decrypt(String encryptedData) throws Exception 
    {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.DECRYPT_MODE, key);
        // byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedData);
        byte[] decodedValue = encryptedData.getBytes();
        byte[] decValue = c.doFinal(decodedValue);
        String decryptedValue = new String(decValue);
        return decryptedValue;
    }
    private static Key generateKey() throws Exception 
    {
        Key key = new SecretKeySpec(keyValue, ALGO);
        return key;
}

}
