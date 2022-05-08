package me.sjplus.SonicjoGameFramework.math;

public class Vector2D {

	public double x, y;

	public Vector2D(double x, double y) {
		
		this.set(x, y);
		
	}
	
	public Vector2D() {
		
		this.set(0, 0);
		
	}
	
	public Vector2D(Vector2D vec) {
		
		this.set(vec);
		
	}
	
	public void set(double x, double y) {
		
		this.x = x;
		this.y = y;
		
	}
	
	public void set(Vector2D vec) {
		
		this.set(vec.x, vec.y);
		
	}
	
	public void add(double x, double y) {
		
		this.x += x;
		this.y += y;
		
	}
	
	public void add(Vector2D vec) {
		
		this.add(vec.x, vec.y);
		
	}
	
	public void sub(double x, double y) {
		
		this.x -= x;
		this.y -= y;
		
	}
	
	public void sub(Vector2D vec) {
		
		this.sub(vec.x, vec.y);
		
	}
	
	public void multiply(double x, double y) {
		
		this.x *= x;
		this.y *= y;
		
	}
	
	public void multiply(Vector2D vec) {
		
		this.multiply(vec.x, vec.y);
		
	}
	
	public void divide(double x, double y) {
		
		this.x /= x;
		this.y /= y;
		
	}
	
	public void divide(Vector2D vec) {
		
		this.divide(vec.x, vec.y);
		
	}
	
	public void rotate(double degrees) {
		
		double cos = Math.cos(Math.toRadians(degrees)), sin = Math.sin(Math.toRadians(degrees));
		
		this.x = cos * x + sin * y;
		this.y = cos * y - sin * x;
		
	}
	
}
