package org.wahlzeit.model;

public class Coordinate {
	private double x;
	private double y;
	private double z;
	static private double epsilon = 0.0000001;
	
	public Coordinate(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public double getZ() {
		return z;
	}
	
	public double getDistance(Coordinate coordinate) {
		if(coordinate == null) {
			throw new IllegalArgumentException("Can't compute distance!");
		}
		double xSquared = (coordinate.getX() - x) * (coordinate.getX() - x);
		double ySquared = (coordinate.getY() - y) * (coordinate.getY() - y);
		double zSquared = (coordinate.getZ() - z) * (coordinate.getZ() - z);

		return Math.sqrt(xSquared + ySquared + zSquared);
	}
	
	private boolean isEqual(Coordinate c) {
		return Math.abs(x - c.getX()) < epsilon && Math.abs(y - c.getY()) < epsilon && 
				Math.abs(z - c.getZ()) < epsilon;
	}
	
	public boolean equals(Coordinate c) {
		if(c == null) {
			return false;
		}
		return isEqual(c);
	}
}
