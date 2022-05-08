package me.sjplus.SonicjoGameFramework.math;

import static java.lang.Math.*;

public final class MathUtil {

	public static double clamp(double x, double min, double max) {
		
		return min(max(x, min), max);
		
	}
	
	public static double calcDistance2(double x0, double x1, double y0, double y1) {
		
		return sqrt(pow(x0 - x1, 2) + pow(y0 - y1, 2));
		
	}
	
	public static double calcDistance2(Vector2D vec1, Vector2D vec2) {
		
		return calcDistance2(vec1.x, vec2.x, vec1.y, vec2.y);
		
	}
	
}
