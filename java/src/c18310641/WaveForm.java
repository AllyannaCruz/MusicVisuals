package c18310641;

import processing.core.*;

public class WaveForm
{
    MyVisual mv;
    float cy = 0;

    float scrwidth = 1024;
    float scrheight = 500;

    public WaveForm(MyVisual mv)
    {
        this.mv = mv;
        cy = this.mv.height / 2;
    }

    public void vert()
    {
        mv.colorMode(PApplet.HSB);
        mv.strokeWeight(1);
        mv.smooth();
        for(int i = 0 ; i < mv.getAudioBuffer().size() ; i ++)
        {
            mv.stroke(
                PApplet.map(i, 0, mv.getAudioBuffer().size(), 0, 255)
                , 255
                , 255
            );

            mv.line(i, 0, i, mv.height + mv.height * mv.getAudioBuffer().get(i));
            mv.rotate((float) (Math.PI * 3.0));
        } // end for
    } // end vert()

} // end Waveform clss