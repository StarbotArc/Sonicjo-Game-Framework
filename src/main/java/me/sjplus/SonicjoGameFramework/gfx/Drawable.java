package me.sjplus.SonicjoGameFramework.gfx;

public abstract class Drawable extends Render {
	
	public Drawable(int width, int height) {
		super(width, height);
	}
	
	public abstract void update(double delta);
	public abstract void render(Render render);

}
