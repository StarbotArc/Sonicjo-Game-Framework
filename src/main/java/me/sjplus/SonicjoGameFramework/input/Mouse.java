package me.sjplus.SonicjoGameFramework.input;

import java.awt.event.*;

public class Mouse implements MouseMotionListener, MouseListener, MouseWheelListener {

	public int mouseX, mouseY;
	public int scrollIncrement;
	
	public boolean mouseButton[] = new boolean[3];
	
	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {

		this.scrollIncrement = e.getWheelRotation();
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {

		if (e.getButton() - 1 != -1)
			this.mouseButton[e.getButton()-1] = true;
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {

		if (e.getButton() - 1 != -1)
			this.mouseButton[e.getButton()-1] = false;
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mouseDragged(MouseEvent e) {

		this.mouseX = e.getX();
		this.mouseY = e.getY();
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {

		this.mouseX = e.getX();
		this.mouseY = e.getY();
		
	}

}
