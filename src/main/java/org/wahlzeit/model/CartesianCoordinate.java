/*
 * CartesianCoordinate
 * 
 * version 1.0
 * 
 * Date: 18.11.18
 * 
 * License: AGPLv3
 */

package org.wahlzeit.model;

public class CartesianCoordinate implements Coordinate{
	private double x;
	private double y;
	private double z;
	
	
	public CartesianCoordinate(double x, double y, double z) {
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
	
	public double getDistance(CartesianCoordinate coordinate) {
		
		double xSquared = (coordinate.getX() - x) * (coordinate.getX() - x);
		double ySquared = (coordinate.getY() - y) * (coordinate.getY() - y);
		double zSquared = (coordinate.getZ() - z) * (coordinate.getZ() - z);

		return Math.sqrt(xSquared + ySquared + zSquared);
	}
	
	private boolean isEqual(CartesianCoordinate c) {
		return Math.abs(x - c.getX()) < EPSILON && Math.abs(y - c.getY()) < EPSILON && 
				Math.abs(z - c.getZ()) < EPSILON;
	}
	
	public boolean equals(Object c) {
		if(c == null || !(c instanceof CartesianCoordinate)) {
			return false;
		}
		return isEqual((CartesianCoordinate)c);
	}

	@Override
	public CartesianCoordinate asCartesianCoordinate() {
		return this;
	}

	@Override
	public double getCartesianDistance(Coordinate c) {
		if(c == null) {
			throw new IllegalArgumentException("Can't compute distance");
		}
		return getDistance(c.asCartesianCoordinate());
	}

	@Override
	public SphericCoordinate asSphericCoordinate() {
		double radius = Math.sqrt(x * x + y * y + z * z);
		if(radius == 0) {
			return new SphericCoordinate(0.0, 0.0, 0.0);
		}
		double theta = Math.acos(z / radius);
		double phi;
		if(x != 0) {
			phi = Math.atan(y / x);
			if(x < 0) {
				phi += Math.signum(y) * Math.PI/2;
			}
		} else {
			phi = Math.signum(y) * Math.PI/2;
		}
		return new SphericCoordinate(phi, theta, radius);
	}

	@Override
	public double getCentralAngle(Coordinate c) {
		SphericCoordinate sc = this.asSphericCoordinate();
		return sc.getCentralAngle(c);
	}

	@Override
	public boolean isEqual(Coordinate c) {
		if(c == null) {
			return false;
		}
		return isEqual(c.asCartesianCoordinate());
	}
}
