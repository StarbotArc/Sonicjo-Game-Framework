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
	
	public void draw(Render render, int x, int y, float w, float h) {
		
		float scaleX = (float) w / render.width;
		float scaleY = (float) h / render.height;
		
		for (int yp = 0; yp < (int) (render.height * scaleY); yp++) {
			
			int yPix = yp + y;
			
			if (yPix < 0 || yPix >= height)
				continue;
			
			for (int xp = 0; xp < (int) (render.width * scaleX); xp++) {
				
				int xPix = xp + x;
			
				if (xPix < 0 || xPix >= width)
					continue;
				
				if (render.pixels[(int) (xp / scaleX) + (int) (yp / scaleY) * render.width] >= 0)
					this.pixels[xPix + yPix * this.width] = render.pixels[(int) (xp / scaleX) + (int) (yp / scaleY) * render.width];
				
			}
			
		}
		
	}
	
	public void draw(Render render, int x, int y, float scale) {
		
		draw(render, x, y, render.width * scale, render.height * scale);
		
	}
	
	public void draw(Render render, int x, int y) {
		
		draw(render, x, y, 1.0f);
		
	}
	
	public void drawPixel(int x, int y, int color) {
		
		if (x < 0 || y < 0 || x >= width || y >= height)
			return;
		
		this.pixels[x + y * width] = color;
		
	}
	
	public void fill(int color, int xOff, int yOff, int width, int height) {
		
		for (int y = 0; y < height; y++) {
			
			int yPix = yOff + y;
			
			for (int x = 0; x < width; x++) {
			
				int xPix = xOff + x;
				
				this.pixels[xPix + yPix * this.width] = color;
			
			}
			
		}
		
	}
	
	public void fill(int color) {
		
		this.fill(color, 0, 0, width, height);
		
	}
	
	public Render copyData(int x, int y, int width, int height) {
		
		int[] data = new int[width * height];
		
		for (int y1 = 0; y1 < height; y1++) {
			
			int yPix = y1 + y;
			
			for (int x1 = 0; x1 < width; x1++) {
				
				int xPix = x1 + x;
				
				data[x1 + y1 * width] = this.pixels[xPix + yPix * this.width];
				
			}
			
		}
		
		Render render = new Render(width, height);
		
		render.pixels = data;
		
		return render;
		
	}
	
	public void multiplyRGB(int r, int g, int b) {
		
		for (int i = 0; i < pixels.length; i++) {

			int p = pixels[i];

			if (p < 0)
				continue;
				
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
