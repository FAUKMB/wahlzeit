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

import java.util.Iterator;
import java.util.LinkedList;

import org.wahlzeit.utils.PatternInstance;

/*
 * Invariants:
 * radius is not Double.Nan or infinite
 * phi is in between 0 and 2*Math.PI and finite and not Double.NaN
 * theta is in between 0 and Math.PI and finite and not Double.NaN
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
public class SphericCoordinate extends AbstractCoordinate {

	private final double phi;
	private final double theta;
	private final double radius;

	private static LinkedList<SphericCoordinate> sphericCoordinates = new LinkedList<>();

	private SphericCoordinate(double phi, double theta, double radius) throws IllegalStateException {
		this.phi = phi;
		this.theta = theta;
		this.radius = radius;
		assertClassInvariants();
	}

	public static SphericCoordinate getSphericCoordinate(double phi, double theta, double radius) {
		Iterator<SphericCoordinate> iter = sphericCoordinates.iterator();
		synchronized (sphericCoordinates) {
			while (iter.hasNext()) {
				SphericCoordinate next = iter.next();
				if (Math.abs(phi - next.getPhi()) < EPSILON && Math.abs(theta - next.getTheta()) < EPSILON
						&& Math.abs(radius - next.getRadius()) < EPSILON) {
					return next;
				}
			}
			SphericCoordinate retval = new SphericCoordinate(phi, theta, radius);
			sphericCoordinates.add(retval);
			return retval;
		}
	}

	public double getPhi() throws IllegalStateException {
		assertClassInvariants();
		return phi;
	}

	public SphericCoordinate setPhi(double phi) throws IllegalStateException, IllegalArgumentException {
		assertClassInvariants();
		if (invalidPhi(phi)) {
			throw new IllegalArgumentException();
		}
		assertClassInvariants();
		return getSphericCoordinate(phi, theta, radius);
	}

	public double getTheta() throws IllegalStateException {
		assertClassInvariants();
		return theta;
	}

	public SphericCoordinate setTheta(double theta) throws IllegalStateException, IllegalArgumentException {
		assertClassInvariants();
		if (invalidTheta(theta)) {
			throw new IllegalArgumentException();
		}
		assertClassInvariants();
		return getSphericCoordinate(phi, theta, radius);
	}

	public double getRadius() {
		assertClassInvariants();
		return radius;
	}

	public SphericCoordinate setRadius(double radius) throws IllegalStateException, IllegalArgumentException {
		assertClassInvariants();
		if (invalidRadius(radius)) {
			throw new IllegalArgumentException();
		}
		assertClassInvariants();
		return getSphericCoordinate(phi, theta, radius);
	}

	@Override
	public CartesianCoordinate asCartesianCoordinate() throws IllegalStateException {
		assertClassInvariants();
		SphericCoordinate before = this;
		double x = radius * Math.sin(theta) * Math.cos(phi);
		double y = radius * Math.sin(theta) * Math.sin(phi);
		double z = radius * Math.cos(theta);
		CartesianCoordinate retval = CartesianCoordinate.getCartesianCoordinate(x, y, z);
		retval.assertClassInvariants();
		assert this.doIsEqual(before);
		return retval;
	}

	@Override
	public SphericCoordinate asSphericCoordinate() throws IllegalStateException {
		assertClassInvariants();
		return this;
	}

	@Override
	public double getCentralAngle(Coordinate c) throws CoordinateException {
		double ret = 0.0;
		try {
			assertNotNull(c);
			assertClassInvariants();
			assertNotZero();
			c.asCartesianCoordinate().assertNotZero();
			SphericCoordinate sc = c.asSphericCoordinate();
			ret = doGetCentralAngle(sc);
			assertClassInvariants();
		} catch (IllegalArgumentException | IllegalStateException e) {
			throw new CoordinateException(e.getMessage());
		}
		return ret;
	}

	private double doGetCentralAngle(SphericCoordinate c) {
		double sinPhi = Math.sin(Math.abs((phi - c.getPhi()) / 2));
		double sinTheta = Math.sin(Math.abs((theta - c.getTheta()) / 2));
		return 2 * Math.asin(Math.sqrt(sinPhi * sinPhi + Math.cos(phi) * Math.cos(c.getPhi()) * sinTheta * sinTheta));
	}

	protected boolean doIsEqual(Coordinate c) {
		SphericCoordinate sc = c.asSphericCoordinate();
		return sc == this;
	}

	@Override
	protected void assertNotZero() {
		if (Math.abs(radius) < EPSILON) {
			throw new IllegalArgumentException();
		}
	}

	@Override
	protected void assertClassInvariants() {
		if (invalidRadius(radius)) {
			throw new IllegalStateException();
		}
		if (invalidPhi(phi)) {
			throw new IllegalStateException();
		}
		if (invalidTheta(theta)) {
			throw new IllegalStateException();
		}
	}

	private boolean invalidTheta(double theta) {
		return (theta < 0.0 || theta > 2 * Math.PI || Double.isInfinite(theta) || Double.isNaN(theta));
	}

	private boolean invalidPhi(double phi) {
		return (phi < 0.0 || phi > 2 * Math.PI || Double.isInfinite(phi) || Double.isNaN(phi));
	}

	private boolean invalidRadius(double radius) {
		return (Double.isInfinite(radius) || Double.isNaN(radius) || radius < 0);
	}

}
