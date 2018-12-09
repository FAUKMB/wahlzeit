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

	public double getCartesianDistance(Coordinate c) throws CoordinateException {
		double retval = 0.0;
		try {
			assertNotNull(c);
			assertClassInvariants();
			Coordinate before = this;
			CartesianCoordinate self = asCartesianCoordinate();
			retval = self.getCartesianDistance(c);
			assertClassInvariants();
			assert this.isEqual(before);
		} catch (IllegalArgumentException|IllegalStateException e) {
			throw new CoordinateException(e.getMessage());
		}
		return retval;
	}

	public double getCentralAngle(Coordinate c) throws CoordinateException {
		double retval = 0.0;
		try {
			assertNotNull(c);
			assertNotZero();
			assertClassInvariants();
			Coordinate before = this;
			c.asCartesianCoordinate().assertNotZero();
			SphericCoordinate self = asSphericCoordinate();
			retval = self.getCentralAngle(c);
			assertClassInvariants();
			assert this.isEqual(before);
		} catch (IllegalArgumentException|IllegalStateException e) {
			throw new CoordinateException(e.getMessage());
		}
		return retval;
	}

	public boolean isEqual(Coordinate c) throws CoordinateException {
		boolean retval = false;
		try {
			assertNotNull(c);
			assertClassInvariants();
			retval = doIsEqual(c);
			assertClassInvariants();
		} catch (IllegalArgumentException|IllegalStateException e) {
			throw new CoordinateException(e.getMessage());
		}
		return retval;
	}

	protected void assertNotNull(Coordinate c) {
		if (c == null) {
			throw new IllegalArgumentException();
		}
	}

	abstract protected void assertNotZero();

	abstract protected void assertClassInvariants();

	abstract protected boolean doIsEqual(Coordinate c);

}
