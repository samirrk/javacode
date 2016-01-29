package com.samirrk.patterns;

public class BXSub implements BISubscriber 
{

	@Override
	public void update(BEvent e) 
	{
		System.out.println("BXSub: " + e.event);
	}

}
