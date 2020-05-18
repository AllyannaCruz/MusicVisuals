package c18310641;

import processing.core.*;

public class Globes
{
    MyVisual mv;
    float glo = 0;
    float scrwidth = 1024;
    float scrheight = 500;
    float angle = 0;

    float x;
    float y;

    public Globes(MyVisual mv) 
    {
        this.mv =  mv;
        glo = this.mv.height / 2;
        x = this.mv.width / 2;
        y = glo; //height
    }

    public void sph_glo()
    {
        mv.colorMode(PApplet.HSB);
        mv.pushMatrix();
        mv.strokeWeight(1);
        mv.lights();
        mv.fill(PApplet.map(mv.getSmoothedAmplitude(), 0, 1, 0, mv.getAudioBuffer().size()), 255, 255);
        mv.stroke(PApplet.map(mv.getSmoothedAmplitude(), 0, 1, mv.getAudioBuffer().size(), 0), 255, 255);
        mv.camera(mv.mouseX/2, mv.mouseY/2, mv.mouseX/3, mv.mouseX, mv.mouseY, 0, 0, 1, 0);
        mv.translate(mv.mouseX, mv.mouseY, -250);
        mv.rotateY(angle);
        mv.rotateX(angle);
        mv.sphere(28 + (mv.getAmplitude() * 300));
        mv.popMatrix();

        
        angle += 0.01f;
    } // end sph_glo()
    
} // end Globe class