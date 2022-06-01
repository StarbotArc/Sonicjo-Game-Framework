package me.sjplus.SonicjoGameFramework.gfx;

public class RenderingUtilities {

	public static FontRenderer sys_font = new FontRenderer(Sprite.createSprite("font.png"), 1, 5, 7, 130, 28, "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvwxyz" + "0123456789!?.:," + ";/" + "%-+*&^<>" + "|[]{}()'" + '"' + "$# ");
	
	public static void drawFont(Render render, String text, int x, int y, int col, float scale) {
		
		FontRenderer font = sys_font;
		
		font.fontsheet.multiplyColor(col);
		sys_font.draw(render, text, x, y, scale);
		
	}
	
}
