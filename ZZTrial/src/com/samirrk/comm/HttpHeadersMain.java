package com.samirrk.comm;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class HttpHeadersMain 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		URL obj;
		try 
		{
			obj = new URL("http://www.advertzoomstatic.de/admin/getCreativePreview?crId=93921&ss=3aha6uOU-aGuTEf");
			URLConnection conn = obj.openConnection();
			
			//get all headers
			Map<String, List<String>> map = conn.getHeaderFields();
			for (Map.Entry<String, List<String>> entry : map.entrySet()) 
			{
				System.out.println("Key : " + entry.getKey() + " ,Value : " + entry.getValue());
			}

			//get header by 'key'
			String server = conn.getHeaderField("Server");
		} 
		catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
