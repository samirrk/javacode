package com.samirrk.patterns;

public class CWidgetMacFactory implements CIWidgetFactory 
{
	CWndMac widgetWnd;
	
	@Override
	public CIWindow createWidgetWindow() 
	{
		widgetWnd = new CWndMac();
		return widgetWnd;
	}


}
