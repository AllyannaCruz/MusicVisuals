package c18310641;

import processing.core.PApplet;

public class Bubbles 
{
    MyVisual mv;
    float circ = 0;
    float scrwidth = 1024;
    float scrheight = 500;

    float x;
    float y;


    public Bubbles(MyVisual mv)
    {
        this.mv =  mv;
        circ = this.mv.height / 2;
        x = this.mv.width / 2;
        y = circ; //height
    }

    public void render()
    {
       mv.colorMode(PApplet.HSB);
       mv.smooth();
       mv.noFill();

       for(int i = 0 ; i < mv.getAudioBuffer().size() ; i ++)
       {
           mv.stroke(
               PApplet.map(i, 0, mv.getAudioBuffer().size(), 0, 255)
               , 255
               , 255
           );
           
           mv.translate((float) (scrwidth * 0.8), (float) (scrheight * 0.8));
           mv.rotate((float) (Math.PI * 3.0));
           mv.ellipse(scrwidth/4, scrheight/2, circ + circ * mv.getAudioBuffer().get(i), circ);
       } // end for

    } // end render()

    // For the bubbles to move up
    public void floup() //must call from MyVisual!!
    {
        circ--;
        circ = circ + mv.random(-2, 2);
    } // end floup

    public void moveback() // so ball won't disappear off screen , call from MyVisual!!!
    {
        if( circ > mv.width || circ < 0)
        {
            circ = circ * - 1;
            flodown();
        } //end if

        if( circ > mv.height || circ < 0)
        {
            circ = circ * - 1;
            flodown();
        } //end if

    } // end moveback()

    public void flodown() //bubbles to descend
    {
        circ++;
        circ = circ - mv.random(-2, 2);
    } // end flodown()

    //For now bubbles are just floating

} // end Bubbles class