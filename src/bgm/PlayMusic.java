package bgm;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * setup a bgm for game
 * @author cuifu
 */
public class PlayMusic {
	
	/**
	 * Play BGM on a loop
	 */
	public void playMuisc() {
		try{
			File m= new File("src/bm/Justhea - Mediterranean Sea FINALMASTER.wav");
			AudioInputStream audioInput = AudioSystem.getAudioInputStream(m);
			Clip clip = AudioSystem.getClip();
			clip.open(audioInput);
			clip.start();
			clip.loop(Clip.LOOP_CONTINUOUSLY);
		}
		catch(LineUnavailableException | UnsupportedAudioFileException | IOException e)
		{
			e.printStackTrace();
		}
	}
}