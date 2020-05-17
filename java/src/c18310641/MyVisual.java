package c18310641;

import ie.tudublin.Visual;
import ie.tudublin.VisualException;
//import ddf.minim.*;
//import processing.sound.*; -- must download zip file ?

public class MyVisual extends Visual 
{    
    WaveForm wf;
    AudioBandsVisual abv;
    Bubbles bub;
    Square sqr;
    
    //Minim minim;
    //AudioPlayer player; // make sure to spell stuff correctly!!
    //AudioSample as;

    int frameSize = 512;
    int sampleRate = 44100;
    
    boolean changesqr = false;

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

        if(key == 's')
        {
            changesqr = ! changesqr;
        }
    }

    public void setup()
    {
        
        //minim = new Minim(this);
        setFrameSize(256);

        startMinim();
        //loadAudio("love4eva.mp3");
        loadAudio("hihigh.mp3");
       
        

        // Call this instead to read audio from the microphone
        //startListening(); 
        
        wf = new WaveForm(this);
        abv = new AudioBandsVisual(this);
        bub = new Bubbles(this);
        sqr = new Square(this);
    }



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
        
        // Call this is you want to use frequency bands
        calculateFrequencyBands(); 

        // Call this is you want to get the average amplitude
        calculateAverageAmplitude();        
        //wf.render(); -- the waves moving
        //abv.render(); -- bars movings
        bub.render(); // -- bubbles moving
        bub.floup(); // bubbless float up
        bub.moveback(); // bubbles to not disappear off screen
        bub.flodown(); // bubbles to float down
        
        if(changesqr)
        {
            sqr.render(); // -- bubbles moving
            sqr.floup(); // bubbless float up
            sqr.moveback(); // bubbles to not disappear off screen
            sqr.flodown();
        }

        //draw hearts
        hearts(); //heart at middle
    }

    void hearts() 
    {
         
        //hearts
        //background(255);
        //fill(255,0,255);
        translate(width/2,3*height/4);
        smooth();
        colorMode(HSB);
        strokeWeight(5);
        // not colour, COLOR!! 
        //
        
        
        for (int i=0; i<61; i++) { // i<freqbrands

            float x = (float) (0.25 * (-pow(i, 2) + 40 * i + 1200) * sin((PI * i) / 180));
            float y = (float) (-0.25 * (-pow(i, 2) + 40 * i + 1200) * cos((PI * i) / 180));

            point(x,y); // use these to place your little hearts
            point(-x,y); // use these to place your little hearts

            //colour
           stroke(map(i, 0, 61, 0, 255), 255, 255);
            
        
        } //end for
        
    } // end hearts()


}
