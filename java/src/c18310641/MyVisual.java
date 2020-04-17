package c18310641;

import ie.tudublin.Visual;
import ie.tudublin.VisualException;
//import ddf.minim.*;
//import processing.sound.*; -- must download zip file ?

public class MyVisual extends Visual 
{    
    WaveForm wf;
    AudioBandsVisual abv;
    //Minim minim;
    //AudioPlayer player; // make sure to spell stuff correctly!!
    //AudioSample as;

    int frameSize = 512;
	int sampleRate = 44100;

    public void settings()
    {
        size(1024, 500);
        
        // Use this to make fullscreen
        //fullScreen();

        // Use this to make fullscreen and use P3D for 3D graphics
        //fullScreen(P3D, SPAN); 
    }

    public void keyPressed()
    {
        if (key == ' ')
        {
            getAudioPlayer().cue(0); 
            getAudioPlayer().play();
        }
    }

    public void setup()
    {
        
        //minim = new Minim(this);
        setFrameSize(256);

        startMinim();
        loadAudio("heroplanet.mp3");
        //getaAp().play();
        

        // Call this instead to read audio from the microphone
        //startListening(); 
        
        wf = new WaveForm(this);
        abv = new AudioBandsVisual(this);
        
    }

    /*
    public void keyPressed()
    {
        if (key == ' ')
        {
            getAudioPlayer().cue(0); 
            getAudioPlayer().play();
        }
    }
    */
    

    public void draw()
    {
        background(0);
        try
        {
            // Call this if you want to use FFT data
            calculateFFT(); 
        }
        catch(VisualException e)
        {
            e.printStackTrace();
        }
        /*
        //hearts
        background(255);
        translate(width/2,3*height/4);
        

        for (int i=0; i<61; i++) {
            float x = (float) (0.25 * (-pow(i, 2) + 40 * i + 1200) * sin((PI * i) / 180));
            float y = (float) (-0.25 * (-pow(i, 2) + 40 * i + 1200) * cos((PI * i) / 180));
            point(x,y); // use these to place your little hearts
            point(-x,y); // use these to place your little hearts
        } //end for
        */
        
        // Call this is you want to use frequency bands
        calculateFrequencyBands(); 

        // Call this is you want to get the average amplitude
        calculateAverageAmplitude();        
        wf.render();
        abv.render();
    }
}
