package com.samirrk.patterns;

public class BMain 
{

	public static void main(String[] args) 
	{
		BEvtPublisher eventer = new BEvtPublisher();
		
		BISubscriber xsub = new BXSub();
		BISubscriber ysub = new BYSub();
		
		eventer.subscribe(xsub);
		eventer.subscribe(ysub);
		
		eventer.generateEvent("Event no. 1");
	}

}
