package c18310641;

import ie.tudublin.Visual;
import ie.tudublin.VisualException;

public class MyVisual extends Visual {
    WaveForm wf;
    AudioBandsVisual abv;
    Bubbles bub;
    Square sqr;
    Stars star;
    Sticks stick;
    Horizon hzn;
    Globes globe;
    FloHex hexg;

    int frameSize = 512;
    int sampleRate = 44100;

    boolean changesqr = false;
    boolean multstr = false;
    boolean scrbg = false; // change screen background colour
    int sph = 0;

    public void settings() {
        size(1024, 500, P3D);
        println("CWD: " + System.getProperty("user.dir"));

        // Use this to make fullscreen
        // fullScreen();

        // Use this to make fullscreen and use P3D for 3D graphics
        // fullScreen(P3D, SPAN);
    }

    public void keyPressed() {
        if (key == ' ') {
            getAudioPlayer().cue(0);
            getAudioPlayer().play();
        }

        if (key == '2') {
            multstr = !multstr;
        }

        if (key == 's') {
            changesqr = !changesqr;
        }

        if (key == '8') {
            scrbg = !scrbg;
        }

    } // end keyPressed()

    public void mouseClicked() {
        if (sph == 0) 
        {
            globe.sph_glo();
        }
    }

    public void setup() {

        // minim = new Minim(this);
        setFrameSize(256);

        startMinim();
        // loadAudio("love4eva.mp3");
        loadAudio("hihigh.mp3");
        //loadAudio("zayn.mp3");
        //loadAudio("losingyou.mp3");

        // Call this instead to read audio from the microphone
        // startListening();

        wf = new WaveForm(this);
        abv = new AudioBandsVisual(this);
        bub = new Bubbles(this);
        sqr = new Square(this);
        star = new Stars(this);
        stick = new Sticks(this);
        hzn = new Horizon(this);
        globe = new Globes(this);
        hexg = new FloHex(this);
    } // end setup()

    public void draw() {
        background(0);
        try {
            // Call this if you want to use FFT data
            calculateFFT();
        } catch (VisualException e) {
            e.printStackTrace();
        }

        // Call this is you want to use frequency bands
        calculateFrequencyBands();

        // Call this is you want to get the average amplitude
        calculateAverageAmplitude();
        wf.vert(); // the waves moving, rainbow and see through
        // abv.render(); -- bars movings

        bub.render();
        bub.floup();
        bub.moveback();
        bub.flodown();

        if (scrbg) // change background colour to white to black and black to white
        {
            background(255);
        }

        if (changesqr) {
            sqr.render(); // bubbles moving
        }

        if (multstr) // to draw stars, I tried to code stars but I ended up making hexagons instead of stars
        {
            star.starDraw2();
            star.floup();
            star.moveback();
            star.flodown();
        }
        
        hexg.render(); // hexagons floating and looks like it's coming from behind and into the screen

        stick.stickwave(); // sticks that shows the waveform

        hzn.hrzn(); // waves at the middle

        // draw hearts
        hearts(); // heart at middle but disperses according to AudioBuffer()
        heartdraw();

        

    } // end draw()


    void hearts() // get heart to move
    {
        colorMode(HSB);
        smooth();
        strokeWeight(5);
        
        for(int j=0; j < getAudioBuffer().size(); j++)
        {
            translate(width/2,3*height/4);
            for (int i=0; i < getAudioBuffer().size(); i++) 
            { 
                float x = (float) (0.25 * (-pow(i, 2) + 40 * i + 1200) * sin((PI * i) / 180));
                float y = (float) (-0.25 * (-pow(i, 2) + 40 * i + 1200) * cos((PI * i) / 180));

                point(getAudioBuffer().get(i) * x,y); // places dots
                point(getAudioBuffer().get(i) * -x,y); // places dots

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


    //heart keeps its shape, you can still see that it's a heart
    void heartdraw()  
    {
        colorMode(HSB);
        smooth();
        strokeWeight(5);
        
        for(int j=0; j < getAudioBuffer().size(); j++)
        {
            translate(width/2,3*height/4);
            for (int i=0; i < getAudioBuffer().size(); i++) 
            { 
                float x = (float) (0.25 * (-pow(i, 2) + 40 * i + 1200) * sin((PI * i) / 180));
                float y = (float) (-0.25 * (-pow(i, 2) + 40 * i + 1200) * cos((PI * i) / 180));

                point(x,y); // places dots
                point(-x,y); // places dots

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
    } // end heartdraw()
    

} // end MyVisual class
