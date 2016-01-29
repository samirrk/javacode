package com.samirrk.patterns;

import java.util.ArrayList;

public class BEvtPublisher
{
	public ArrayList<BISubscriber> subscribers = null;
	public BEvent ev;
	
	public BEvtPublisher()
	{
		ev = new BEvent();
		subscribers = new ArrayList<BISubscriber>();
	}
	
	public void subscribe(BISubscriber sub) 
	{
		subscribers.add(sub);
	}

	public void notifySubs() 
	{
		for (BISubscriber s : subscribers)
		{
			s.update(ev);
		}
	}
	
	
	public void generateEvent(String eventStr)
	{
		ev.event = eventStr;
		notifySubs();
	}

}
