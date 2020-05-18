package c18310641;

import processing.core.*;

public class Sticks 
{
    MyVisual mv;
    float stk = 0;
    float scrwidth = 1024;
    float scrheight = 500;

    float x;
    float y;


    public Sticks(MyVisual mv)
    {
        this.mv =  mv;   
        stk = this.mv.height / 2;
        x = this.mv.width / 2;
        y = stk; //height
    }




    public void stickwave()
    {
        mv.colorMode(PApplet.HSB);
        mv.strokeWeight(3);
        for(int i = 0 ; i < mv.getAudioBuffer().size() ; i ++)
        {
            mv.stroke(
                PApplet.map(i, 0, mv.getAudioBuffer().size(), 0, 255)
                , 255
                , 255
            );

            mv.line(700, mv.height, stk + stk * mv.getAudioBuffer().get(i), i);
        } // end for
    } // end horizon()
} // end Sticks class