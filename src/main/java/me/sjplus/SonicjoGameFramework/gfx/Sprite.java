package me.sjplus.SonicjoGameFramework.gfx;

import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;

public class Sprite extends Render {

	private BufferedImage img;
	
	/**
	 * @deprecated This constructor is deprecated, please use the static function createSprite.
	 * @param path
	 * @param width
	 * @param height
	 */
	@Deprecated
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
		
		for (int i = 0; i < this.pixels.length; i++) {
			
			if (this.pixels[i] >> 24 == 0) {
				
				this.pixels[i] = -1;
				continue;
				
			}
			
			this.pixels[i] = this.pixels[i] & 0xffffff;
			
			if (this.pixels[i] < 0)
			System.out.println(this.pixels[i]);
			
		}
		
	}
	
	public Sprite getGlpyh(int x, int y, int width, int height) {
		
		return new Sprite(this.img.getSubimage(x, y, width, height), width, height);
		
	}
	
	public static Sprite createSprite(String path) {
		
		try {
	
			BufferedImage i = ImageIO.read(Sprite.class.getResource('/' + path));
			
			return new Sprite(i, i.getWidth(), i.getHeight());
	
		} catch (IOException e) {
	
			e.printStackTrace();
		
		}
		
		return null;
		
	}
	
	public static Sprite createSpriteExternally(String path) {
		
		try {
			
			BufferedImage i = ImageIO.read(new File(path));
			
			return new Sprite(i, i.getWidth(), i.getHeight());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return null;
		
	}
	
}
