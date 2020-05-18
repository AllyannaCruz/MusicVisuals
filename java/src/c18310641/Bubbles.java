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

    private String movement;

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

    public MyVisual getMv() {
        return mv;
    }

    public void setMv(MyVisual mv) {
        this.mv = mv;
    }

    public float getCirc() {
        return circ;
    }

    public void setCirc(float circ) {
        this.circ = circ;
    }

    public float getScrwidth() {
        return scrwidth;
    }

    public void setScrwidth(float scrwidth) {
        this.scrwidth = scrwidth;
    }

    public float getScrheight() {
        return scrheight;
    }

    public void setScrheight(float scrheight) {
        this.scrheight = scrheight;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public String setMovement()
    {
        return movement;
    }

    public void getMovement(String name)
    {
        this.movement = movement;
    }

    //For now bubbles are just floating
    public void update()
    {
        System.out.println("Bubble pop!");
    }


    @Override
    public String toString() {
        return "Bubbles [circ=" + circ + ", movement=" + movement + ", mv=" + mv + ", scrheight=" + scrheight
                + ", scrwidth=" + scrwidth + ", x=" + x + ", y=" + y + "]";
    }

} // end Bubbles class