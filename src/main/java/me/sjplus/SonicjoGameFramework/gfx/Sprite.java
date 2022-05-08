package me.sjplus.SonicjoGameFramework.gfx;

import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;

public class Sprite extends Render {

	private BufferedImage img;
	
	public Sprite(String path, int width, int height) {
	
		super(width, height);

		try {
			
			BufferedImage i = ImageIO.read(Sprite.class.getResourceAsStream('/' + path));
			this.img = i;
			
			this.pixels = i.getRGB(0, 0, width, height, null, 0, width);
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
	}

	public Sprite(BufferedImage img, int width, int height) {
		
		super(width, height);
		
		this.img = img;
		this.pixels = img.getRGB(0, 0, width, height, null, 0, width);
		
	}
	
	public Sprite getGlpyh(int x, int y, int width, int height) {
		
		return new Sprite(this.img.getSubimage(x, y, width, height), width, height);
		
	}
	
}
