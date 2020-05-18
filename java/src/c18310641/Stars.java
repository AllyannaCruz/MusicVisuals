package c18310641;

import processing.core.*;
//import java.util.*;

public class Stars 
{
    MyVisual mv;
    float starshap = 0; // look if u can change into private
    float x = 0;
    float y = 0;
    float a = 0;

    float radius1 = 30;
    float radius2 = 70;
    int npoints = 6;
    float scrwidth = 1024;
    float scrheight = 500;
    double TWO_PI = Math.PI * 2;
    float angle = (float) (TWO_PI / npoints);
    float halfAngle = (float) (angle / 2.0);
    float starx = (float) (x + Math.cos(a) * radius2);
    float stary = (float) (y + Math.sin(a) * radius1);

    float frameCount = 512;

    public Stars(MyVisual mv)
    {
        this.mv =  mv;
        starshap = this.mv.height / 2;
    }



    public void starDraw(float x, float y, float radius1, float radius2, int npoints) 
    {
        mv.colorMode(PApplet.HSB);
        mv.smooth();
        mv.noFill();
 
        for(int i = 0 ; i < mv.getAudioBuffer().get(i) ; i ++)
        {
            mv.stroke(
                PApplet.map(i, 0, mv.getAudioBuffer().size(), 0, mv.getAudioBuffer().get(i))
                , 255
                , 255
            );
        } //end for

        for(int j = 0; j < mv.getAudioBuffer().size(); j++)
        {
            mv.beginShape();
            for (float a = 0; a <= TWO_PI; a += angle) 
            {
                mv.vertex(starx, stary);
                starx = (float) (mv.getAudioBuffer().get((int) a) + Math.cos(a + halfAngle) * mv.getAmplitude());  // try fix this
                stary = (float) (mv.getAudioBuffer().get((int) a) + Math.sin(a + halfAngle) * mv.getAmplitude());
                mv.vertex(starx, stary);
            } // end inner for
            mv.endShape();
        } // end outer for
        
    } // end render()

    public void starDraw2()
    {
            mv.pushMatrix();
            //mv.translate((float) (scrwidth*0.8), (float) (scrheight*0.5));
            mv.translate((float) (scrwidth*0.8), mv.getAudioBuffer().size());
            mv.rotate((float) (mv.getFrameSize()/ 100.0));
            starDraw(x, y, radius1, radius2, npoints); 
            mv.popMatrix();
        
    } // end starDraw2()
   
    // For the star to move up
    public void floup() //must call from MyVisual!!
    {
        starshap--;
        starshap = starshap + mv.random(-2, 2);
    } // end floup

    public void moveback() // so star won't disappear off screen , call from MyVisual!!!
    {
        if( starshap > mv.width || starshap < 0)
        {
            starshap = starshap * - 1;
            flodown();
        } //end if

        if( starshap > mv.height || starshap < 0)
        {
            starshap = starshap * - 1;
            flodown();
        } //end if

    } // end moveback()

    public void flodown() //star to descend
    {
        starshap++;
        starshap = starshap - mv.random(-2, 2);
    } // end flodown()

    //For now star is just floating

} // end Stars class