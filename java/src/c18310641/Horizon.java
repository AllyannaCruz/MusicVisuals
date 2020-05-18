package c18310641;

import processing.core.*;

public class Horizon 
{
    MyVisual mv;
    float hr = 0;

    float scrwidth = 1024;
    float scrheight = 500;

    public Horizon(MyVisual mv)
    {
        this.mv = mv;
        hr = this.mv.height / 2;
    }

    public void hrzn()
    {
        mv.colorMode(PApplet.HSB);
        for(int i = 0 ; i < mv.getAudioBuffer().size() ; i ++)
        {
            mv.stroke(
                PApplet.map(i, 0, mv.getAudioBuffer().size(), 0, 255)
                , 255
                , 255
            );

            mv.line(i, hr, i + 800,  hr + hr * mv.getAudioBuffer().get(i));
        } // end for
    } // end horizon()
}