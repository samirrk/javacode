package com.samirrk.patterns;

/*
 * The C Project
 * -------------
 * 
 * This project demonstrates the Abstract Factory Design Pattern
 * 
 * This pattern is demonstrated to deal with a UI toolkit that targets multiple OSs. There are two class
 * hierarchies - one for the windows themselves and another for the factories that create windows.
 * 
 *  Consider that a higher level construct needs to be created that will create a panel of windows. This 
 *  requires two things (1) to create the window for the specific platform and (2) call methods on it. 
 *  To achieve this, the panel builder is passed a factory that is appropriate for the OS. 
 *  
 *  The panel builder uses the factory to create as many windows as required. The window objects returned 
 *  have the methods required for positioning, drawing, etc. The panel builder then uses the methods exposed 
 *  from the "window" interface to arrange and draw the panel.
 * 
 */

public class C_Info 
{

}
