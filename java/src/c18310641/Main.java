package c18310641;

import example.CubeVisual;
// no need to import example.MyVisual because the file for submission is in the c18310641 package;


public class Main
{	
    
	public void startUI()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new CubeVisual());		
    }
    

	public static void main(String[] args)
	{
        Main main = new Main();
        main.myVisual();
        //main.startUI();			
        
    }
    
    //heart
    /*
    public void startHeart()
    {
        String[] a = {"MAIN"};
        processing.core.PApplet.runSketch(a, new MyVisual());
    }
    */

    //MyVisual
    public void myVisual()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new MyVisual());
    }


} // end class