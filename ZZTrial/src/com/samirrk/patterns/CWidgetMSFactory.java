package com.samirrk.patterns;

public class CWidgetMSFactory implements CIWidgetFactory 
{
	CWndMS widgetWnd;
	
	@Override
	public CIWindow createWidgetWindow() 
	{
		widgetWnd = new CWndMS();
		return widgetWnd;
	}


}
