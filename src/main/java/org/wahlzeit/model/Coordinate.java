/*
 * Coordinate
 * 
 * version 1.0
 * 
 * Date: 18.11.18
 * 
 * License: AGPLv3
 */

package org.wahlzeit.model;

public interface Coordinate {
	static public final double EPSILON = 0.0000001;
	
	public CartesianCoordinate asCartesianCoordinate();
	
	public double getCartesianDistance(Coordinate c);
	
	public SphericCoordinate asSphericCoordinate();
	
	public double getCentralAngle(Coordinate c);
	
	public boolean isEqual(Coordinate c);
}
