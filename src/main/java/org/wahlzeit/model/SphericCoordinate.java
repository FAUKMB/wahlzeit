/*
 * SphericCoordinate
 * 
 * version 1.0
 * 
 * Date: 18.11.18
 * 
 * License: AGPLv3
 */

package org.wahlzeit.model;

public class SphericCoordinate implements Coordinate {
	
	private double phi;
	private double theta;
	private double radius;

	public SphericCoordinate(double phi, double theta, double radius) {
		this.phi =  phi;
		this.theta = theta;
		this.radius = radius;
	}
	
	public double getPhi() {
		return phi;
	}

	public void setPhi(double phi) {
		this.phi = phi;
	}

	public double getTheta() {
		return theta;
	}

	public void setTheta(double theta) {
		this.theta = theta;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public CartesianCoordinate asCartesianCoordinate() {
		double x = radius * Math.sin(theta) * Math.cos(phi);
		double y = radius * Math.sin(theta) * Math.sin(phi);
		double z = radius * Math.cos(theta);
		return new CartesianCoordinate(x, y, z);
	}

	@Override
	public double getCartesianDistance(Coordinate c) {
		CartesianCoordinate cc = this.asCartesianCoordinate();
		return cc.getCartesianDistance(c);
	}

	@Override
	public SphericCoordinate asSphericCoordinate() {
		return this;
	}

	@Override
	public double getCentralAngle(Coordinate c) {
		if(c == null) {
			throw new IllegalArgumentException("Can't compute central angle");
		}
		SphericCoordinate sc = c.asSphericCoordinate();
		return doGetCentralAngle(sc);
	}
	
	private double doGetCentralAngle(SphericCoordinate c) {
		double sinPhi = Math.sin(Math.abs((phi - c.getPhi()) /2));
		double sinTheta = Math.sin(Math.abs((theta - c.getTheta()) / 2));
		return 2 * Math.asin(Math.sqrt(sinPhi * sinPhi + Math.cos(phi) * Math.cos(c.getPhi()) *
				sinTheta * sinTheta));
	}
	
	
	@Override
	public boolean isEqual(Coordinate c) {
		if(c == null) {
			return false;
		}
		SphericCoordinate sc = c.asSphericCoordinate();
		return isEqual(sc);
	}
	
	private boolean isEqual(SphericCoordinate sc) {
		return Math.abs(phi - sc.getPhi()) < EPSILON && Math.abs(theta - sc.getTheta()) < EPSILON && 
				Math.abs(radius - sc.getRadius()) < EPSILON;
	}

}
