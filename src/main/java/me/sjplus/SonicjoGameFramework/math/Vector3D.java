package me.sjplus.SonicjoGameFramework.math;

public class Vector3D {

	public double x, y, z;

	public Vector3D(double x, double y, double z) {
		
		this.set(x, y, z);
		
	}
	
	public Vector3D() {
		
		this.set(0, 0, 0);
		
	}
	
	public Vector3D(Vector3D vec) {
		
		this.set(vec);
		
	}
	
	public void set(double x, double y, double z) {
		
		this.x = x;
		this.y = y;
		this.z = z;
		
	}
	
	public void set(Vector3D vec) {
		
		this.set(vec.x, vec.y, vec.z);
		
	}
	
	public void add(double x, double y, double z) {
		
		this.x += x;
		this.y += y;
		this.z += z;
		
	}
	
	public void add(Vector3D vec) {
		
		this.add(vec.x, vec.y, vec.z);
		
	}
	
	public void sub(double x, double y, double z) {
		
		this.x -= x;
		this.y -= y;
		this.z -= z;
		
	}
	
	public void sub(Vector3D vec) {
		
		this.sub(vec.x, vec.y, vec.z);
		
	}
	
	public void multiply(double x, double y, double z) {
		
		this.x *= x;
		this.y *= y;
		this.z *= z;
		
	}
	
	public void multiply(Vector3D vec) {
		
		this.multiply(vec.x, vec.y, vec.z);
		
	}
	
	public void divide(double x, double y, double z) {
		
		this.x /= x;
		this.y /= y;
		this.z /= z;
		
	}
	
	public void divide(Vector3D vec) {
		
		this.divide(vec.x, vec.y, vec.z);
		
	}
	
	public void rotateX(double degrees) {
		
		double cos = Math.cos(Math.toRadians(degrees)), sin = Math.sin(Math.toRadians(degrees));

		this.y = cos * this.y + sin * this.z;
		this.z = cos * this.z - sin * this.y;
		
	}
	
	public void rotateY(double degrees) {
		
		double cos = Math.cos(Math.toRadians(degrees)), sin = Math.sin(Math.toRadians(degrees));
		
		this.x = cos * this.x + sin * this.z;
		this.z = cos * this.z - sin * this.x;
		
	}
	
	public void rotateZ(double degrees) {
		
		double cos = Math.cos(Math.toRadians(degrees)), sin = Math.sin(Math.toRadians(degrees));

		this.x = cos * this.x + sin * this.y;
		this.y = cos * this.y - sin * this.x;
		
	}
	
}
