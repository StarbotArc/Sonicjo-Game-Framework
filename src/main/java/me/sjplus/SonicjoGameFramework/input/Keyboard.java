package me.sjplus.SonicjoGameFramework.input;

import java.awt.event.*;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.CharArrayReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.*;

import com.google.common.base.Charsets;

public class Keyboard implements KeyListener {

	private Map<Integer, Key> keys = new HashMap<>();
	private List<Character> chars = new ArrayList<>();
	private boolean typing; 
	
	public Keyboard() {
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		if (keys.size() > 0) {
			
			Key k = keys.get(e.getKeyCode());
			
			if (k != null)
				k.setPressed(true);
			
		}
		
		if (typing) {
	
			if (e.getKeyCode() != KeyEvent.VK_BACK_SPACE) {
			
				chars.add(e.getKeyChar());
				System.out.print(e.getKeyChar());
			
			} else {
			
				chars.remove(chars.size() - 1);
				System.out.print("bckspce");
				
			}
		
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		if (keys.size() > 0) {
			
			Key k = keys.get(e.getKeyCode());
			
			if (k != null)
				k.setPressed(false);
			
		}
			
	}
	
	public Key getKey(int keycode) {
		
		return keys.get(keycode); 
		
	}
	
	public boolean keyPressed(int keycode) {
		
		return getKey(keycode).pressed;
		
	}
	
	public void addKey(int keycode) {
		
		keys.put(keycode, new Key());
		
	}
	
	public void removeKey(int keycode) {
		
		keys.remove(keycode);
		
	}
	
	public void setKeyTyping(boolean b) {
		
		this.typing = b;
		
	}
	
	public class Key {
		
		private boolean pressed = false;
		
		public Key() {
			
		}
		
		public boolean getPressed() {
			
			return pressed;
			
		}
		
		public void setPressed(boolean b) {
			
			pressed = b;
			
		}
		
	}
	
}
