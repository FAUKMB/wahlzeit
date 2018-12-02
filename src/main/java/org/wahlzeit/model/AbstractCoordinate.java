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
		assertNotNull(c);
		assertClassInvariants();
		Coordinate before = this;
		CartesianCoordinate self = asCartesianCoordinate();
		double retval = self.getCartesianDistance(c);
		assertClassInvariants();
		assert this.isEqual(before);
		return retval;
	}
	
	public double getCentralAngle(Coordinate c) {
		assertNotNull(c);
		assertNotZero();
		assertClassInvariants();
		Coordinate before = this;
		c.asCartesianCoordinate().assertNotZero();
		SphericCoordinate self = asSphericCoordinate();
		double retval = self.getCentralAngle(c);
		assertClassInvariants();
		assert this.isEqual(before);
		return retval;
	}
	
	public boolean isEqual(Coordinate c) {
		assertNotNull(c);
		assertClassInvariants();
		boolean retval = doIsEqual(c);
		assertClassInvariants();
		return retval;
	}
	
	private void assertNotNull(Coordinate c) {
		if(c == null) {
			throw new IllegalArgumentException();
		}
	}
	
	abstract protected void assertNotZero();
	
	abstract protected void assertClassInvariants();
	
	abstract protected boolean doIsEqual(Coordinate c);
	
}
