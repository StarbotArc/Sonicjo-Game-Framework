package me.sjplus.SonicjoGameFramework;

import java.awt.*;
import java.awt.image.*;
import java.io.IOException;

import javax.swing.JFrame;

import me.sjplus.SonicjoGameFramework.gfx.*;
import me.sjplus.SonicjoGameFramework.input.*;
import me.sjplus.SonicjoGameFramework.net.*;

public class Display {

	public int width, height;
	public String title;
	
	private ThreadHandler thread;
	private Canvas canvas;
	private BufferedImage data;
	private int[] pixels;
	private Screen screen;
	private JFrame frame;
	private Keyboard keyboard;
	private Mouse mouse;
	
	private SocketClient sClient;
	
	public Display(ThreadHandler thread, String title, int width, int height) {
		
		this.thread = thread;
		this.thread.display = this;
		this.title = title;
		this.width = width;
		this.height = height;
		
		this.frame = new JFrame(this.title);
		this.canvas = new Canvas();
		this.canvas.setPreferredSize(new Dimension(this.width, this.height));
		this.frame.setSize(this.width, this.height);
		this.frame.setPreferredSize(new Dimension(this.width, this.height));
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.frame.setVisible(true);
		this.frame.setLayout(new BorderLayout());
		this.frame.add(canvas, BorderLayout.CENTER);
		this.frame.setLocationRelativeTo(null);
		this.frame.pack();
		
		data = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		pixels = (((DataBufferInt)data.getRaster().getDataBuffer()).getData());
		
		mouse = new Mouse();
		keyboard = new Keyboard();
		
		canvas.addMouseListener(mouse);
		canvas.addMouseMotionListener(mouse);
		canvas.addMouseWheelListener(mouse);
		
		canvas.addKeyListener(keyboard);
		
	}
	
	public void createSocketClient(String host, int port) {
		
		this.sClient = new SocketClient(port, host);
		
	}
	
	public void nullifySocketClient() {
		
		this.sClient.close();
		this.sClient = null;
		
	}
	
	public JFrame getFrame() {
		
		return frame;
		
	}
	
	public Mouse getMouse() {
		
		return mouse;
		
	}
	
	public Keyboard getKeyboard() {
		
		return keyboard;
		
	}

	public void setScreen(Screen screen) {
		
		this.screen = screen;
		
	}
	
	public void start() {
		
		this.thread.start();
		
	}
	
	public void stop() {
		
		this.thread.stop();
		
	}
	
	public void update(double delta) {
		
		if (sClient != null) {
			
			try {
	
				sClient.listen();
		
			} catch (IOException e) {
	
				e.printStackTrace();
	
			}
		
		}
		
		screen.update(mouse, keyboard, delta);
		
	}
	
	public void render() {
		
		BufferStrategy bs = this.canvas.getBufferStrategy();
		
		if (bs == null) {
			
			this.canvas.createBufferStrategy(2);
			return;
			
		}
		
		Graphics g = bs.getDrawGraphics();
		
		screen.render();
		
		for (int i = 0; i < pixels.length; i++) {
			
			pixels[i] = screen.pixels[i];
			
		}
		
		g.drawImage(this.data, 0, 0, null);
		
		g.dispose();
		bs.show();
		
	}
	
	public enum DisplayHint {
		
		BORDERLESS,
		BORDER,
		FULLSCREEN,
		NO_FULLSCREEN;
		
	}
	
	public void configureDisplay(DisplayHint... hints) {
		
		JFrame frame = getFrame();
		
		for (DisplayHint hint : hints) {
			
			if (hint == DisplayHint.BORDERLESS) {
				
				frame.setVisible(false);
				frame.setUndecorated(true);
				frame.setVisible(true);
				
			}
			
			if (hint == DisplayHint.BORDER) {
				
				frame.setVisible(false);
				frame.setUndecorated(false);
				frame.setVisible(true);
				
			}
			
			if (hint == DisplayHint.FULLSCREEN) {
			
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				
			}
			
			if (hint == DisplayHint.NO_FULLSCREEN) {
				
				frame.setExtendedState(JFrame.NORMAL);
				
			}
			
		}
		
	}
	
}
