/*
 * AbstractCoordinate
 * 
 * version 1.0
 * 
 * Date: 24.11.18
 * 
 * License: AGPLv3
 */

package org.wahlzeit.model;

public abstract class AbstractCoordinate implements Coordinate {
	
	public double getCartesianDistance(Coordinate c) {
		CartesianCoordinate self = asCartesianCoordinate();
		return self.getCartesianDistance(c);
	}
	
	public double getCentralAngle(Coordinate c) {
		SphericCoordinate self = asSphericCoordinate();
		return self.getCentralAngle(c);
	}
	
	public boolean isEqual(Coordinate c) {
		if(c == null) {
			return false;
		}
		return doIsEqual(c);
	}
	
	abstract protected boolean doIsEqual(Coordinate c);
	
}
