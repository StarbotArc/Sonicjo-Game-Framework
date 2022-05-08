package me.sjplus.SonicjoGameFramework.gfx;

import me.sjplus.SonicjoGameFramework.input.*;

public class Screen extends Render {
	
	public Menu currentMenu;
	
	public Screen(int width, int height) {
	
		super(width, height);

	}
	
	public void update(Mouse mouse, Keyboard keyboard, double delta) {
	
		if (this.currentMenu != null) {
			
			this.currentMenu.update(mouse, keyboard, delta);
			return;
			
		}
		
	}
	
	public void render() {
		
		if (this.currentMenu != null) {
			
			this.currentMenu.render();
			this.draw(currentMenu, width, height);
			
			return;
			
		}
		
	}
	
	public void setMenu(Menu menu) {
		
		this.currentMenu = menu;
		
	}

}
