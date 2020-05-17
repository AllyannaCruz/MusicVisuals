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

       for(int i = 0 ; i < mv.getAudioBuffer().size() ; i ++)
       {
           mv.fill(
               PApplet.map(i, 0, mv.getAudioBuffer().size(), 0, 255)
               , 255
               , 255
           );

           mv.rect(i, sq, sq + sq * mv.getAudioBuffer().get(i), sq);
       } // end for

    } // end render()

    // For the bubbles to move up
    public void floup() //must call from MyVisual!!
    {
        sq--;
        sq = sq + mv.random(-2, 2);
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
        sq = sq - mv.random(-2, 2);
    } // end flodown()
}