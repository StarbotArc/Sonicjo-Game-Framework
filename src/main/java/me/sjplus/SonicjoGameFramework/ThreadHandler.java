package me.sjplus.SonicjoGameFramework;

import java.util.*;

public abstract class ThreadHandler {

	public static final long NANO_SECOND = 1000000000;
	
	protected boolean running = false;
	public Display display;

	protected List<ThreadHandlerListener> listeners = new ArrayList<>();
	
	protected ThreadHandler(ThreadHandlerListener... listeners) {
		
		this.listeners = Arrays.asList(listeners);
		
	}
	
	public abstract void start();
	public abstract void stop();
	
	public abstract void init();
	
	public double convertToRate(double r) {
		
		return (double) NANO_SECOND / r;
		
	}
	
}
