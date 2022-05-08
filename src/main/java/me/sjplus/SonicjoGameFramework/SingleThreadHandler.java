package me.sjplus.SonicjoGameFramework;

public class SingleThreadHandler extends ThreadHandler implements Runnable {

	private Thread thread;
	
	private double ticksPerNS;
	private boolean lockframes;
	private boolean debug;
	
	public SingleThreadHandler(double tickrate, boolean lockframes, boolean debug, ThreadHandlerListener... listeners) {
		
		super(listeners);
		
		this.ticksPerNS = this.convertToRate(tickrate);
		this.lockframes = lockframes;
		this.debug = debug;
		
		this.thread = new Thread(this);
		this.thread.setName("SJ-GF: Game Thread (Single-Thread)");
		
	}
	
	public void start() {
		
		this.thread.start();
		this.running = true;
		
	}
	
	public void stop() {
	
		try {
		
			this.thread.join();
	
		} catch (InterruptedException e) {
		
			e.printStackTrace();

		}
		
		this.running = false;
		
	}
	
	public void init() {
		
	}
	
	public void run() {
		
		init();
		long lastNanos = System.nanoTime();
		double delta = 0;
		int ticks = 0;
		int frames = 0;
		long lastMillis = System.currentTimeMillis();
		boolean shouldRender = false;
		
		while (running) {
			
			delta += (System.nanoTime() - lastNanos) / ticksPerNS;
			lastNanos = System.nanoTime();
			
			shouldRender = delta >= 1 || !lockframes;
			
			while (delta >= 1) {
				
				display.update(delta);
				ticks++;
				
				delta--;
				
			}
			
			try {
			
				Thread.sleep(4);
			
			} catch (InterruptedException e) {
		
				e.printStackTrace();
		
			}
			
			if (shouldRender) {
			
				display.render();
				
				frames++;
				shouldRender = false;
			
			}
		
			if (System.currentTimeMillis() - lastMillis >= 1000 && this.debug) {
				
				System.out.println("frames: " + frames + ", " + "ticks: " + ticks);
				frames = 0;
				ticks = 0;
				
				lastMillis = System.currentTimeMillis();
				
			}
			
		}
	
		stop();
		
	}

}
