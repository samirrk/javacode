package com.samirrk.patterns;

public class CMain 
{

	public static void main(String[] args) 
	{
		String os = "MSWINDOWS";
		
		CIWidgetFactory wfact = null;
		
		if (os.equals("MACOS"))
		{
			wfact = new CWidgetMacFactory();
		}
		else if (os.equals("MSWINDOWS"))
		{
			wfact = new CWidgetMSFactory();
		}
		
		CPanelBuilder pbuilder = new CPanelBuilder();
		pbuilder.buildWidgetPanel(wfact);
		
		pbuilder.wnd1.setTitle("Something");
	}

}
