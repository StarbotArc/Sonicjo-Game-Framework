package me.sjplus.SonicjoGameFramework.gfx;

public class FontRenderer {

	private Sprite fontsheet;
	private int offsetX, charWidth, charHeight, imgWidth, imgHeight;
	private String characters;
	
	public FontRenderer(Sprite fontsheet, int offsetX, int charWidth, int charHeight, int imgWidth, int imgHeight, String characters) {
		
		this.fontsheet = fontsheet;
		this.offsetX = offsetX;
		this.charWidth = charWidth;
		this.charHeight = charHeight;
		this.imgWidth = imgWidth;
		this.imgHeight = imgHeight;
		this.characters = characters;
		
	}
	
	public void draw(Render render, String text, int x, int y, float scale) {
		
		int yOff = 0;
		int xOff = 0;
		
		for (int i = 0; i < text.length(); i++) {
			
			if (text.charAt(i) == '\n') {
				
				yOff += this.charHeight * scale;
				xOff = 0;
				continue;
				
			}
			
			int ind = characters.indexOf(text.charAt(i)); 
			int glyphX = (ind % (imgWidth / charWidth)) * charWidth;
			int glyphY = (ind / (imgWidth / charWidth)) * charHeight;
			
			render.draw(fontsheet.getGlpyh(glyphX, glyphY, charWidth, charHeight), x + xOff, y + yOff, scale);
			
			xOff += (this.charWidth + this.offsetX) * scale;
			
		}
		
	}
	
	public void draw(Render render, String text, int x, int y) {
		
		this.draw(render, text, x, y, 1.0f);
		
	}
	
}
