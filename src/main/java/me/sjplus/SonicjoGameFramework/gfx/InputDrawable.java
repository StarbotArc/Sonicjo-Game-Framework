package me.sjplus.SonicjoGameFramework.gfx;

import me.sjplus.SonicjoGameFramework.input.*;

public abstract class InputDrawable extends Drawable {

	public InputDrawable(int width, int height) {
		super(width, height);
	}

	public abstract void update(Mouse mouse, Keyboard keyboard, double delta);
	
}
