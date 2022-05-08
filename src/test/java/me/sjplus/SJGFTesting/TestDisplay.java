package me.sjplus.SJGFTesting;

import me.sjplus.SonicjoGameFramework.*;

public class TestDisplay {

	public static void main(String[] args) {
		
		Display d = new Display(new SingleThreadHandler(60, false, false), "a", 800, 600);
		TestScreen s = new TestScreen(800, 600);
		d.setScreen(s);
		d.start();
		
	}
	
}
