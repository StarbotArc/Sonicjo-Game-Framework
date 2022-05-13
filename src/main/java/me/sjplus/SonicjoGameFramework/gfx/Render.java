package me.sjplus.SonicjoGameFramework.gfx;

public class Render {

	public int width;
	public int height;
	public int[] pixels;
	
	public Render(int width, int height) {
		
		this.width = width;
		this.height = height;
		this.pixels = new int[width*height];
		
	}
	
	public void draw(Render render, int x, int y, float scale) {
		
		for (int yp = 0; yp < (int) (render.width * scale); yp++) {
			
			int yPix = yp + y;
			
			if (yPix < 0 || yPix >= height)
				continue;
			
			for (int xp = 0; xp < (int) (render.height * scale); xp++) {
				
				int xPix = yp + y;
			
				if (xPix < 0 || xPix >= width)
					continue;
				
				if (render.pixels[(int) (xp / scale) + (int) (yp / scale) * render.width] < 0)
					this.pixels[xPix + yPix * this.width] = render.pixels[(int) (xp / scale) + (int) (yp / scale) * render.width];
				
			}
			
		}
		
	}
	
	public void draw(Render render, int x, int y) {
		
		draw(render, x, y, 1.0f);
		
	}
	
	public void drawPixel(int x, int y, int color, int alpha) {
		
		if (x < 0 || y < 0 || x >= width || y >= height)
			return;
		
		if (alpha < 255) {
		
			int pixel = this.pixels[x + y * width];
			int r = (pixel >> 16) & 0xff;
			int g = (pixel >> 8) & 0xff;
			int b = (pixel) & 0xff;
			
			if (pixel > color) {
			
				r = r - (((color >> 16) & 0xff)) * (alpha)/255;
				g = g - (((color >> 8) & 0xff)) * (alpha)/255;
				b = b - ((color & 0xff)) * (alpha)/255;
			
			} else {
				
				r = r + ((color & 0xff)) * (alpha)/255;
				g = g + (((color >> 8) & 0xff)) * (alpha)/255;
				b = b + (((color >> 16) & 0xff)) * (alpha)/255;
				
			}
			
			this.pixels[x + y * width] = r | g << 8 | b << 16;
			return;
			
		}
		
		this.pixels[x + y * width] = color;
		
	}
	
	public void fill(int color) {
		
		for (int i = 0; i < this.pixels.length; i++) {
			
			this.pixels[i] = color;
			
		}
		
	}
	
}
