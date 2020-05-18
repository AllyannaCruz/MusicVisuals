package c18310641;

import processing.core.PImage;

public class Smiley extends Bubbles
{

    PImage img;

    public Smiley(MyVisual mv) 
    {
        super(mv);
        // TODO Auto-generated constructor stub
    }
    
    public void pic()
    {
        img = loadImage("Mr._Smiley_Face.png");
    }

    private PImage loadImage(String string) {
        return null;
    }
} // end Smiley()