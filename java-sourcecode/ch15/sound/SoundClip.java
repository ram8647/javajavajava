import javax.sound.sampled.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.io.IOException;

public class SoundClip {

    public static void main(String[] args) {
	int times = 1;
	Clip clip;
	URL url = null;
	try {
	    url = new 
		URL("http://cooplogic.com/cheyney/sound/liftMusic.wav");
	    AudioInputStream audio =
		AudioSystem.getAudioInputStream(url); // get stream from url
	    DataLine.Info info = new DataLine.Info(Clip.class, 
						   audio.getFormat()); // info needed for line

	    if (!AudioSystem.isLineSupported(info)) {
		System.err.println("Audio file not supported: " +
				   info);
		return;
	    }
	    try {
		clip = (Clip) AudioSystem.getLine(info); // the clip does the work
		clip.open(audio); // open the stream.
		clip.start(); // start the stream on a separate thread.
		// loop until clip has finished
		while (clip.getFramePosition() < clip.getFrameLength()) {
		    try {
			Thread.sleep(10);
		    } catch (Exception e) {
			e.printStackTrace();
		    }
		}
	    } catch (LineUnavailableException ex) {
		ex.printStackTrace();
	    }  
	 
	} catch (MalformedURLException e) {
	    System.out.println("Malformed URL: " + url.toString()) ;
	} catch (UnsupportedAudioFileException ae) {
	    System.out.println("not supported: " + ae) ;
	} catch (IOException ioex) {
	    ioex.printStackTrace();
	}
	
    }
}
