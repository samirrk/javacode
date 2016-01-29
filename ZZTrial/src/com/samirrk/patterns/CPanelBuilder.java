package com.samirrk.patterns;

public class CPanelBuilder 
{
	public CIWindow wnd1;
	public CIWindow wnd2;
	public CIWindow wnd3;
	
	public void buildWidgetPanel(CIWidgetFactory wfact)
	{
		
		wnd1 = wfact.createWidgetWindow();
		wnd1.setTitle("Text");
		wnd1.wndPosition(0, 0, 320, 60);
		
		wnd2 = wfact.createWidgetWindow();
		wnd2.setTitle("Graphics");
		wnd2.wndPosition(320, 0, 320, 300);
		
		wnd3 = wfact.createWidgetWindow();
		wnd3.setTitle("Charts");
		wnd3.wndPosition(0, 60, 320, 240);
		
	}
}
