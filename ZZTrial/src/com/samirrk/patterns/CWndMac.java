package com.samirrk.patterns;

public class CWndMac implements CIWindow 
{
	public String wndTitle ="";
	public int wndWidth = 0;
	public int wndHeight = 0;
	
	@Override
	public void setTitle(String title) 
	{
		wndTitle = title;
		// call Mac set title API
	}

	@Override
	public void wndPosition(int x, int y, int w, int h) 
	{
		wndWidth = w;
		wndHeight = h;
		// call Mac resizing API
	}

}
