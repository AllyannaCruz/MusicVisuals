package c18310641;

import processing.core.*;

public class Bubbles 
{
    MyVisual mv;
    float circ = 0;


    public Bubbles(MyVisual mv)
    {
        this.mv =  mv;
        circ = this.mv.height / 2;
    }

    public void render()
    {
       mv.colorMode(PApplet.HSB);

       for(int i = 0 ; i < mv.getAudioBuffer().size() ; i ++)
       {
           mv.stroke(
               PApplet.map(i, 0, mv.getAudioBuffer().size(), 0, 255)
               , 255
               , 255
           );

           mv.ellipse(i, circ, circ + circ * mv.getAudioBuffer().get(i), circ);
       } // end for

    } // end render()
}