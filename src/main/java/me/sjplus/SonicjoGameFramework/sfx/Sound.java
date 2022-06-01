package me.sjplus.SonicjoGameFramework.sfx;

import java.io.IOException;

import javax.sound.sampled.*;

public class Sound {

	protected Clip clip;
	protected boolean loop;
	
	public Sound(String path) {
		
		try {
			
			this.clip = AudioSystem.getClip();
			AudioInputStream audio = AudioSystem.getAudioInputStream(getClass().getResource("/" + path));
			this.clip.open(audio);
			
		} catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
		
			e.printStackTrace();
		
		}
		
	}

	public void play() {
		
		this.clip.start();
		
	}
	
	public void shouldLoop(boolean loop) {
		
		this.clip.loop(loop? -1 : 0);
		this.loop = loop;
		
	}
	
	public boolean looping() {
		
		return loop;
		
	}
	
	public void stop() {
		
		this.clip.stop();
		
	}
	
}
