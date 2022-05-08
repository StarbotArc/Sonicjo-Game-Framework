package me.sjplus.SonicjoGameFramework.math;

public class Vector4D {

	public double x, y, z, w;

	public Vector4D(double x, double y, double z, double w) {
		
		this.set(x, y, z, w);
		
	}
	
	public Vector4D() {
		
		this.set(0, 0, 0, 0);
		
	}
	
	public Vector4D(Vector4D vec) {
		
		this.set(vec);
		
	}
	
	public void set(double x, double y, double z, double w) {
		
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
		
	}
	
	public void set(Vector4D vec) {
		
		this.set(vec.x, vec.y, vec.z, vec.w);
		
	}
	
	public void add(double x, double y, double z, double w) {
		
		this.x += x;
		this.y += y;
		this.z += z;
		this.w += w;
		
	}
	
	public void add(Vector4D vec) {
		
		this.add(vec.x, vec.y, vec.z, vec.w);
		
	}
	
	public void sub(double x, double y, double z, double w) {
		
		this.x -= x;
		this.y -= y;
		this.z -= z;
		this.w -= w;
		
	}
	
	public void sub(Vector4D vec) {
		
		this.sub(vec.x, vec.y, vec.z, vec.w);
		
	}
	
	public void multiply(double x, double y, double z, double w) {
		
		this.x *= x;
		this.y *= y;
		this.z *= z;
		this.w *= w;
		
	}
	
	public void multiply(Vector4D vec) {
		
		this.multiply(vec.x, vec.y, vec.z, vec.w);
		
	}
	
	public void divide(double x, double y, double z, double w) {
		
		this.x /= x;
		this.y /= y;
		this.z /= z;
		this.w /= w;
		
	}
	
	public void divide(Vector4D vec) {
		
		this.divide(vec.x, vec.y, vec.z, vec.w);
		
	}
	
	public void matrixMultiply(Matrix4x4 m) {
		
		double nx = this.x * m.matrix[0][0] + this.y * m.matrix[0][1] + this.z * m.matrix[0][2] + this.w * m.matrix[0][3];
		double ny = this.x * m.matrix[1][0] + this.y * m.matrix[1][1] + this.z * m.matrix[1][2] + this.w * m.matrix[1][3];
		double nz = this.x * m.matrix[2][0] + this.y * m.matrix[2][1] + this.z * m.matrix[2][2] + this.w * m.matrix[2][3];
		double nw = this.x * m.matrix[3][0] + this.y * m.matrix[3][1] + this.z * m.matrix[3][2] + this.w * m.matrix[3][3];
		this.x = nx;
		this.y = ny;
		this.z = nz;
		this.w = nw;
		
	}
	
}
