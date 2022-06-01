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
		
		for (int yp = 0; yp < (int) (render.height * scale); yp++) {
			
			int yPix = yp + y;
			
			if (yPix < 0 || yPix >= height)
				continue;
			
			for (int xp = 0; xp < (int) (render.width * scale); xp++) {
				
				int xPix = xp + x;
			
				if (xPix < 0 || xPix >= width)
					continue;
				
				if (render.pixels[(int) (xp / scale) + (int) (yp / scale) * render.width] >= 1)
					this.pixels[xPix + yPix * this.width] = render.pixels[(int) (xp / scale) + (int) (yp / scale) * render.width];
				else
					System.out.println(render.pixels[(int) (xp / scale) + (int) (yp / scale) * render.width]);
				
			}
			
		}
		
	}
	
	public void draw(Render render, int x, int y) {
		
		draw(render, x, y, 1.0f);
		
	}
	
	public void drawPixel(int x, int y, int color) {
		
		if (x < 0 || y < 0 || x >= width || y >= height)
			return;
		
		this.pixels[x + y * width] = color;
		
	}
	
	public void fill(int color) {
		
		for (int i = 0; i < this.pixels.length; i++) {
			
			this.pixels[i] = color;
			
		}
		
	}
	
	public void multiplyRGB(int r, int g, int b) {
		
		for (int i = 0; i < pixels.length; i++) {

			int p = pixels[i];

			int r1 = (p >> 16) & 0xff;
			int g1 = (p >> 8) & 0xff;
			int b1 = (p) & 0xff;

			r1 = r1 * r / 255;
			g1 = g1 * g / 255;
			b1 = b1 * b / 255;
			
			if ((r1 << 16 | g1 << 8 | b1) >= 0)
				pixels[i] = r1 << 16 | g1 << 8 | b1;
			
		}
		
	}
	
	public void multiplyColor(int col) {
		
		int r = (col >> 16) & 0xff;
		int g = (col >> 8) & 0xff;
		int b = (col) & 0xff;
		
		this.multiplyRGB(r, g, b);
		
	}
	
}
