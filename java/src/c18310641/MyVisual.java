package c18310641;

import ie.tudublin.Visual;
import ie.tudublin.VisualException;
//import ddf.minim.*;

public class MyVisual extends Visual 
{    
    WaveForm wf;
    AudioBandsVisual abv;
    Bubbles bub;
    Square sqr;
    Stars star;
    Sticks stick;
    Horizon hzn;
    //Hearts heart;
    
    //Minim minim;
    //AudioPlayer player; // make sure to spell stuff correctly!!
    //AudioSample as;

    int frameSize = 512;
    int sampleRate = 44100;
    
    boolean changesqr = false;
    boolean multsqr = false;
    boolean scrbg = false; //change screen background colour

    public void settings()
    {
        size(1024, 500, P3D);
        println("CWD: " + System.getProperty("user.dir"));
        
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

        if(key == '2')
        {
            multsqr = ! multsqr;
        }

        if(key == 's')
        {
            changesqr = ! changesqr;
        }

        if(key == '8')
        {
            scrbg = ! scrbg;
        }
    }

    public void setup()
    {
        
        //minim = new Minim(this);
        setFrameSize(256);

        startMinim();
        loadAudio("love4eva.mp3");
        //loadAudio("hihigh.mp3");
       
        

        // Call this instead to read audio from the microphone
        //startListening(); 
        
        wf = new WaveForm(this);
        abv = new AudioBandsVisual(this);
        bub = new Bubbles(this);
        sqr = new Square(this);
        star = new Stars(this);
        stick = new Sticks(this);
        hzn = new Horizon(this);
        //heart = new Hearts(this);
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
        wf.vert(); //-- the waves moving
        //wf.sticks(); // stick waves
        //abv.render(); -- bars movings


        if(scrbg) // change background colour to white to black and black to white
        {
            background(255);
        }

        //put bub in if () and create array list - access them as bub[i] in for loop.
        bub.render(); // -- bubbles moving 
        //bub.floup(); // bubbless float up
        //bub.moveback(); // bubbles to not disappear off screen
        //bub.flodown(); // bubbles to float down
        
        if(changesqr)
        {
            sqr.render(); // -- bubbles moving
            //sqr.floup(); // bubbless float up
            //sqr.moveback(); // bubbles to not disappear off screen
            //sqr.flodown();
        }

        if(multsqr) // another square
        {
            sqr.render(); // -- bubbles moving
            //sqr.floup(); // bubbless float up
            //sqr.moveback(); // bubbles to not disappear off screen
            //sqr.flodown();
        }

        // to draw stars
        //star.render(700, 400);
        star.starDraw2();
        //star.floup();
        //star.moveback();
        //star.flodown();
        
        stick.stickwave();  // edit! getSmoothAmp

        hzn.hrzn(); // waves at the middle

        //heart.render();

        //draw hearts
        hearts(); //heart at middle

        strokeWeight(3); //when mouse pressed a bunch of smaller spheres show up -- put in diff class
        lights();
        stroke(map(getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);
        camera(0, 0, 0, 0, 0, -1, 0, 1, 0);
        translate(0,0, -250);
        sphere(100);
    }

    
    void hearts()  //get heart to move
    {
         
        //hearts
        //background(255);
        //fill(255,0,255);
        //translate(width/2,3*height/4);
        colorMode(HSB);
        smooth();
        strokeWeight(5);
        // not colour, COLOR!! 
        //
        
        for(int j=0; j < getAudioBuffer().size(); j++)
        {
            translate(width/2,3*height/4);
            for (int i=0; i < getAudioBuffer().size(); i++) 
            { 
                float x = (float) (0.25 * (-pow(i, 2) + 40 * i + 1200) * sin((PI * i) / 180));
                float y = (float) (-0.25 * (-pow(i, 2) + 40 * i + 1200) * cos((PI * i) / 180));

                point(getAudioBuffer().get(i)* x,y); // use these to place your little hearts
                point(-x,y); // use these to place your little hearts

                //colour
                //stroke(map(i, 0, 61, 0, 255), 255, 255);
                fill(
                    map(i, 0, getAudioBuffer().size(), getAudioBuffer().size(), 0)
                    , 255
                    , 255
                );

                stroke(
                    map(i, 0, getAudioBuffer().size(), getAudioBuffer().size(), 0)
                    , 255
                    , 255
                );
            } //end for
        } //end outer for
    } // end hearts()
    

} // end MyVisual class
