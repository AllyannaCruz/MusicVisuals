# Music Visualiser Project

Name: Allyanna Riyann Cruz

Student Number: C18310641

# Description of the assignment

For my assignment, I have *circles/bubbles* that change size and colour with the music. They remind me of bubbles, at certain angles you can see a rainbow, reminded me of that.

I have *hexagons* that look like they're twirling, they look a bit like dragon scales. It reminds me of the SuperMario rainbow racetrack. 

There is a *heart* at the middle of the screen that moves and disperses depending on the sound. The dots look like they are dancing to the music. I thought it was cool to have a heart that wasn't connected. 

There are more *hexagons* that are floating around, they look like asteroids floating in the galaxy. I used the camera() function, so it looks like they are flying from your point of view into the screen and around and goes towards you. They look like they are spinning, these also change colour. I have a lot of hexagons because I was trying to code up some stars, but I couldn't get it quite right and I ended up just leaving it to a hexagon.

I modified the *WaveForm.java* class, the waves are on the left  side of the screen and is vertical and see through.

I have *sticks* that look like a spotlight coming from the bottom of the screen, this shows the wave form of whatever sound is playing/hearing.

I have a *horizontal* line at the middle of the screen. It reminds me of the horizon. It changes colour and size depending on the AudioBuffer or AudioBands. It looks like it is moving up or down.

I think my assignment looks cool while you are listening to music. Though it is quite colourful, I find it relaxing to watch.


# Instructions

- When you press the space key, the music starts and the visuals start to move according to the music.
-  The music is a bit delayed, I'm not sure if it's my computer but the music should play after a few seconds.
- When you press the 's' key, squares pop up and change size and colours depending on the AudioBuffer. When pressed again the squares disappear.
- When you press the '2' key, hexagons that don't move show up. The colours are according to the AudioBuffer. 
- When you press the '8' key, the background changes to white and when you press it again it goes back to black.
-  When the *mouse is clicked* a sphere shows up depending on where your mouse is (mouseX, mouseY).

# How it works
1. The circles/bubbles do not move positions. There are many circles (the AudioBuffer size). They move according to the sound. They also change colours according to the sound.

Sphere rotates, changes colour depending on the song, if no sound/song is being layed/heard, then it is just a dot. It also changes size depending on the music, and its location on the screen because of the camera() function.

# What I am most proud of in the assignment
I am most proud of.....


# Markdown Tutorial

This is *emphasis*

This is a bulleted list

- Item
- Item

This is a numbered list

1. Item
1. Item

This is a [hyperlink](http://bryanduggan.org)

# Headings
## Headings
#### Headings
##### Headings

This is code:

```Java
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

So is this without specifying the language:

```
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

This is an image using a relative URL:

![An image](images/p8.png)

This is an image using an absolute URL:

![A different image](https://bryanduggandotorg.files.wordpress.com/2019/02/infinite-forms-00045.png?w=595&h=&zoom=2)

This is a youtube video:

[![YouTube](http://img.youtube.com/vi/J2kHSSFA4NU/0.jpg)](https://www.youtube.com/watch?v=J2kHSSFA4NU)

This is a table:

| Heading 1 | Heading 2 |
|-----------|-----------|
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |

