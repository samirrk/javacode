package com.samirrk.patterns;

public class BYSub implements BISubscriber 
{

	@Override
	public void update(BEvent e) 
	{
		System.out.println("BYSub: " + e.event);
	}

}
