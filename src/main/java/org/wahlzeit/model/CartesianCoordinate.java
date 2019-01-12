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

import java.util.Iterator;
import java.util.LinkedList;

import org.wahlzeit.utils.PatternInstance;

/*
 * Invariants:
 * x, y and z are finite and not Double.NaN
 */
@PatternInstance(
	name = "Chain of Responsibility",
	participants = {
		"Receiver"
	}
)
@PatternInstance(
	name = "Template",
	participants = {
		"Concrete implementation"
	}
)
public class CartesianCoordinate extends AbstractCoordinate {
	private final double x;
	private final double y;
	private final double z;
	
	private static LinkedList<CartesianCoordinate> cartCoordinates = new LinkedList<>();

	private CartesianCoordinate(double x, double y, double z) throws IllegalStateException {
		this.x = x;
		this.y = y;
		this.z = z;
		assertClassInvariants();
	}
	
	public static CartesianCoordinate getCartesianCoordinate(double x, double y, double z) {
		synchronized(cartCoordinates) {
			Iterator<CartesianCoordinate> iter = cartCoordinates.iterator();
			while(iter.hasNext()) {
				CartesianCoordinate next = iter.next();
				if(Math.abs(x - next.getX()) < EPSILON && Math.abs(y - next.getY()) < EPSILON && Math.abs(z - next.getZ()) < EPSILON) {
					return next;
				}
			}
			CartesianCoordinate retval = new CartesianCoordinate(x, y, z);
			cartCoordinates.add(retval);
			return retval;
		}
	}

	public double getX() throws IllegalStateException {
		assertClassInvariants();
		return x;
	}

	public double getY() throws IllegalStateException {
		assertClassInvariants();
		return y;
	}

	public double getZ() throws IllegalStateException {
		assertClassInvariants();
		return z;
	}

	private double getDistance(CartesianCoordinate coordinate) {

		double xSquared = (coordinate.getX() - x) * (coordinate.getX() - x);
		double ySquared = (coordinate.getY() - y) * (coordinate.getY() - y);
		double zSquared = (coordinate.getZ() - z) * (coordinate.getZ() - z);

		return Math.sqrt(xSquared + ySquared + zSquared);
	}

	@Override
	protected boolean doIsEqual(Coordinate cc) {
		CartesianCoordinate c = cc.asCartesianCoordinate();
		return this == c;
	}

	public boolean equals(Object c) {
		if (c == null || !(c instanceof CartesianCoordinate)) {
			return false;
		}
		return doIsEqual((CartesianCoordinate) c);
	}

	@Override
	public CartesianCoordinate asCartesianCoordinate() throws IllegalStateException {
		assertClassInvariants();
		return this;
	}

	@Override
	public double getCartesianDistance(Coordinate c) throws CoordinateException {
		double ret = 0.0;
		try {
			assertNotNull(c);
			assertClassInvariants();
			ret = getDistance(c.asCartesianCoordinate());
			assertClassInvariants();
		} catch (IllegalStateException | IllegalArgumentException e) {
			throw new CoordinateException(e.getMessage());
		}
		return ret;
	}

	@Override
	public SphericCoordinate asSphericCoordinate() throws IllegalStateException {
		assertClassInvariants();
		CartesianCoordinate before = this;
		double radius = Math.sqrt(x * x + y * y + z * z);
		if (radius == 0) {
			return SphericCoordinate.getSphericCoordinate(0.0, 0.0, 0.0);
		}
		double theta = Math.acos(z / radius);
		double phi;
		if (x != 0) {
			phi = Math.atan(y / x);
			if (x < 0) {
				phi += Math.signum(y) * Math.PI / 2;
			}
		} else {
			phi = Math.signum(y) * Math.PI / 2;
		}
		SphericCoordinate retval = SphericCoordinate.getSphericCoordinate(phi, theta, radius);
		retval.assertClassInvariants();
		assert this.doIsEqual(before);
		return retval;
	}

	@Override
	protected void assertNotZero() {
		if (Math.abs(x) < EPSILON && Math.abs(y) < EPSILON && Math.abs(z) < EPSILON) {
			throw new IllegalArgumentException();
		}
	}

	@Override
	protected void assertClassInvariants() {
		if (Double.isNaN(x) || Double.isInfinite(x) || Double.isNaN(y) || Double.isInfinite(y) || Double.isNaN(z)
				|| Double.isInfinite(z)) {
			throw new IllegalStateException();
		}
	}
}
