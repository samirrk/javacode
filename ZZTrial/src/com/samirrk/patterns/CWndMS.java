package com.samirrk.patterns;

public class CWndMS implements CIWindow 
{

	public String wndTitle ="";
	public int wndWidth = 0;
	public int wndHeight = 0;
	
	@Override
	public void setTitle(String title) 
	{
		wndTitle = title;
		// call Windows set title API
	}

	@Override
	public void wndPosition(int x, int y, int w, int h) 
	{
		wndWidth = w;
		wndHeight = h;
		// call Windows resizing API
	}
}
