package c18310641;

import processing.core.PApplet;

public class Bubbles 
{
    MyVisual mv;
    float circ = 0;

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

       for(int i = 0 ; i < mv.getAudioBuffer().size() ; i ++)
       {
           mv.stroke(
               PApplet.map(i, 0, mv.getAudioBuffer().size(), 0, 255)
               , 255
               , 255
           );

           mv.ellipse(1024/2, 500/2, circ + circ * mv.getAudioBuffer().get(i), circ);
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