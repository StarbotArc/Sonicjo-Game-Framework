package me.sjplus.SonicjoGameFramework.sfx;

import java.io.IOException;

import javax.sound.sampled.*;

public class Sound {

	protected Clip clip;
	protected long playPosition;
	
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
		
		this.clip.setMicrosecondPosition(playPosition);
		this.clip.start();
		
		this.playPosition = 0;
		
	}
	
	public void pause() {
		
		this.playPosition = this.clip.getMicrosecondPosition();
		this.stop();
		
	}
	
	public void setPlayPosition(long point) {
		
		if (point < 0 || point > this.clip.getMicrosecondLength()) return;
		
		this.playPosition = point;
		
	}
	
	public void stop() {
		
		this.clip.stop();
		
	}
	
}
