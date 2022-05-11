package me.sjplus.SJGFTesting;

import me.sjplus.SonicjoGameFramework.gfx.*;
import me.sjplus.SonicjoGameFramework.input.*;

public class TestScreen extends Screen {
	
	private Sprite s;
	private String typedThing;

	public TestScreen(int width, int height) {
		super(width, height);
		s = new Sprite("hard.png",16,16);
	}
	
	public void update(Mouse mouse, Keyboard keyboard, double delta) {
		
		keyboard.setKeyTyping(true);
		
		Object charB = keyboard.getCurrentChar();
		
		if (charB != null) {
		
			typedThing += charB;
			System.out.println(charB);
			
		}
		
	}
	
	public void render() {
		
		this.fill(0);
		
		for (int i = 0; i < 100; i++)
			for (int j = 0; j < 100; j++)
				this.drawPixel(i, j, 0xff, 255);
		
		RenderingUtilities.sys_font.draw(this, "Hello", 0, 0);
		//if (typedThing != null)
			//RenderingUtilities.sys_font.draw(this, typedThing, 0, height/2);
		this.draw(s, 16, 16, 5f);
		
	}

}
