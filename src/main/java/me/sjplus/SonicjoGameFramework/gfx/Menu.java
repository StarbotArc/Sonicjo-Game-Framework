package me.sjplus.SonicjoGameFramework.gfx;

import me.sjplus.SonicjoGameFramework.input.*;

public abstract class Menu extends Render{
	
	public Menu(int width, int height) {
	
		super(width, height);

	}
	
	public abstract void update(Mouse mouse, Keyboard keyboard, double delta);
	public abstract void render();

}
