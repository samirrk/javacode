package com.samirrk.comm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * USAGE:
 * From either the browser or a tool like FF Poster, 
 * construct a url: http://localhost:8080 and send
 * it as a GET or POST request. The code below will 
 * print out the request that was received
 */

public class ServerSocketMain extends Thread
{
	private ServerSocket serversocket;
	
	public ServerSocketMain(int port) throws IOException
	{
		serversocket = new ServerSocket(port);
		serversocket.setSoTimeout(100000);
	}
	
	public void run()
	{
		while (true)
		{
			try
			{
				serversocket.getLocalPort();
				Socket socket = serversocket.accept();
				String line;
				
				BufferedReader brdr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				while ((line = brdr.readLine()) != null)
					System.out.println(line);
				socket.close();
			}
			catch(IOException ex)
			{
				System.out.println(ex.getLocalizedMessage());
			}
			
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		try
		{
			Thread t = new ServerSocketMain(8080);
			t.start();
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
		}

	}

}
