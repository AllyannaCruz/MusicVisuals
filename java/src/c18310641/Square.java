package c18310641;

import processing.core.*;

public class Square 
{
    MyVisual mv;
    float sq = 0;

    float x;
    float y;


    public Square(MyVisual mv)
    {
        this.mv =  mv;
        sq = this.mv.height / 2;
        x = this.mv.width / 2;
        y = sq; //height
    }

    public void render()
    {
       mv.colorMode(PApplet.HSB);
       mv.smooth();

       for(int i = 0 ; i < mv.getAudioBuffer().size() ; i ++)
       {
           mv.fill(
               PApplet.map(i, 0, mv.getAudioBuffer().size(), 0, mv.getAudioBuffer().size())
               , 255
               , 255
           );

           mv.rect(mv.random(i), mv.random(i), 55 , 55);
       } // end for

       for(int j = 0 ; j < mv.getAudioBuffer().size() ; j++)
       {
        mv.fill(
            PApplet.map(j, 0, mv.getAudioBuffer().size(), mv.getAudioBuffer().size(), 0)
            , 255
            , 255
        );

        mv.rect(800, mv.random(j), 55 , 55);
       } // end for

    } // end render()

    // For the bubbles to move up
    public void floup() //must call from MyVisual!!
    {
        sq--;
        sq = sq + mv.random(-20, 20);
    } // end floup

    public void moveback() // so ball won't disappear off screen , call from MyVisual!!!
    {
        if( sq > mv.width || sq < 0)
        {
            sq = sq * - 1;
            flodown();
        } //end if

        if( sq > mv.height || sq < 0)
        {
            sq = sq * - 1;
            flodown();
        } //end if

    } // end moveback()

    public void flodown() //bubbles to descend
    {
        sq++;
        sq = sq - mv.random(-20, 20); // change to 2, -2
    } // end flodown()
}