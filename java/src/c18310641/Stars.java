package c18310641;

import processing.core.*;
//import java.util.*;

public class Stars 
{
    MyVisual mv;
    float starshap = 0; 
    float x = 0;
    float y = 0;
    float a = 0;
    float ang = 0;

    float radius1 = 30;
    float radius2 = 70;
    int npoints = 6; // number of vertices -- hexagon
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
        //mv.noFill();
 
        mv.pushMatrix();
        for(int j = 0; j < mv.getAudioBuffer().size(); j++)
        {
            mv.beginShape();
            for (float a = 0; a <= TWO_PI; a += angle) 
            {
                mv.vertex(starx, stary);
                starx = (float) (mv.getAudioBuffer().get((int) a) + Math.cos(a + halfAngle) * 180 ); 
                stary = (float) (mv.getAudioBuffer().get((int) a) + Math.sin(a + halfAngle) * 180 );
                mv.vertex(starx, stary);
                mv.translate((float) (scrwidth*0.8), mv.getAudioBuffer().size());
                mv.rotate((float) (mv.getAudioBuffer().size()/ 100.0));
            } // end inner for
            mv.endShape();
            mv.stroke(
                    PApplet.map(j, 0, mv.getAudioBuffer().size(), 0, mv.getAudioBuffer().size())
                    , 255
                    , 255
                );

                mv.fill(
                    PApplet.map(j, 0, mv.getAudioBuffer().size(), mv.getAudioBuffer().size(), 0)
                    , 255
                    , 255
                );
        } // end outer for
       
        mv.popMatrix();
        //ang += 0.01f;


    } // end starDraw()

    public void hex(float x, float y, float radius1, float radius2, int npoints) 
    {
        mv.colorMode(PApplet.HSB);
        mv.smooth();
        //mv.noFill();
 
        mv.pushMatrix();
        for(int j = 0; j < mv.getAudioBuffer().size(); j++)
        {
            mv.beginShape();
            for (float a = 0; a <= TWO_PI; a += angle) 
            {
                mv.vertex(starx, stary);
                starx = (float) (mv.getAudioBuffer().get((int) a) + Math.cos(a + halfAngle) * 180 );  // try fix this
                stary = (float) (mv.getAudioBuffer().get((int) a) + Math.sin(a + halfAngle) * 180 );
                mv.vertex(starx, stary);
                mv.translate((float) (scrwidth*0.8), mv.getAudioBuffer().size());
                mv.rotate((float) (mv.getAudioBuffer().size()/ 100.0));
                mv.rotate((float) (Math.PI * 3.0));
            } // end inner for
            mv.endShape();
            mv.stroke(
                    PApplet.map(j, 0, mv.getAudioBuffer().size(), 0, mv.getAudioBuffer().size())
                    , 255
                    , 255
                );

                mv.fill(
                    PApplet.map(j, 0, mv.getAudioBuffer().size(), mv.getAudioBuffer().size(), 0)
                    , 255
                    , 255
                );
        } // end outer for
       
        mv.popMatrix();

    } // end hex()

    public void starDraw2()
    {
        starDraw(x, y, radius1, radius2, npoints);
        hex(x, y, radius1, radius2, npoints);

    } // end starDraw2()
   
    // !!! Code down here does not do anything, I wanted the shapes to float up and down at first.
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