package me.sjplus.SonicjoGameFramework.math;

public class Matrix4x4 extends Matrix {

	public Matrix4x4() {
		
		super(4, 4);
		reset();
		
	}
	
	public void reset() {
		
		matrix[0][0] = 1; matrix[0][1] = 0; matrix[0][2] = 0; matrix[0][3] = 0;
		matrix[1][0] = 0; matrix[1][1] = 1; matrix[1][2] = 0; matrix[1][3] = 0;
		matrix[2][0] = 0; matrix[2][1] = 0; matrix[2][2] = 1; matrix[2][3] = 0;
		matrix[3][0] = 0; matrix[3][1] = 0; matrix[3][2] = 0; matrix[3][3] = 1;
		
	}
	
	public void set(Matrix4x4 m) {
		
		this.matrix = m.matrix;
		
	}
	
	public void multiplyVector4(Vector4D vec) {
		
		double x = vec.x * matrix[0][0] + vec.y * matrix[0][1] + vec.z * matrix[0][2] + vec.w * matrix[0][3];
		double y = vec.y * matrix[1][0] + vec.y * matrix[1][1] + vec.z * matrix[1][2] + vec.w * matrix[1][3];
		double z = vec.x * matrix[2][0] + vec.y * matrix[2][1] + vec.z * matrix[2][2] + vec.w * matrix[2][3];
		double w = vec.x * matrix[3][0] + vec.y * matrix[3][1] + vec.z * matrix[3][2] + vec.w * matrix[3][3];
		vec.set(x, y, z, w);
		
	}
	
	public void multiplyMatrix(Matrix4x4 m) {
		
		double x = m.matrix[0][0] * matrix[0][0] + m.matrix[0][1] * matrix[0][1] + m.matrix[0][2] * matrix[0][2] + m.matrix[0][3] * matrix[0][3];
		double y = m.matrix[1][0] * matrix[1][0] + m.matrix[1][1] * matrix[1][1] + m.matrix[1][2] * matrix[1][2] + m.matrix[1][3] * matrix[1][3];
		double z = m.matrix[2][0] * matrix[2][0] + m.matrix[2][1] * matrix[2][1] + m.matrix[2][2] * matrix[2][2] + m.matrix[2][3] * matrix[2][3];
		double w = m.matrix[3][0] * matrix[3][0] + m.matrix[3][1] * matrix[3][1] + m.matrix[3][2] * matrix[3][2] + m.matrix[3][3] * matrix[3][3];
		this.matrix[0][0] = this.matrix[0][1] = this.matrix[0][2] = this.matrix[0][3] = x; 
		this.matrix[1][0] = this.matrix[1][1] = this.matrix[1][2] = this.matrix[1][3] = y;
		this.matrix[2][0] = this.matrix[2][1] = this.matrix[2][2] = this.matrix[2][3] = z;
		this.matrix[3][0] = this.matrix[3][1] = this.matrix[3][2] = this.matrix[3][3] = w;
		
	}
	
	public Vector4D toVec4() {
		
		return new Vector4D(matrix[0][0] + matrix[0][1] + matrix[0][2] + matrix[0][3],
							matrix[1][0] + matrix[1][1] + matrix[1][2] + matrix[1][3],
							matrix[2][0] + matrix[2][1] + matrix[2][2] + matrix[2][3],
							matrix[3][0] + matrix[3][1] + matrix[3][2] + matrix[3][3]);
		
	}
	
}
