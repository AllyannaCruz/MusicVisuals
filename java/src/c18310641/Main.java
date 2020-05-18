package c18310641;

import example.CubeVisual;


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
    


    //MyVisual
    public void myVisual()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new MyVisual());
    }


} // end class