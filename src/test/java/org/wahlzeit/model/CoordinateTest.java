/*
 * CoordinateTest
 * 
 * version 1.0
 * 
 * Date: 30.10.18
 * 
 * License: AGPLv3
 */

package org.wahlzeit.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CoordinateTest {
	private CartesianCoordinate coordinate0;
	private CartesianCoordinate coordinate1;
	private CartesianCoordinate coordinate2;
	private CartesianCoordinate coordinate3;
	private CartesianCoordinate coordinateNegative;
	private SphericCoordinate sc0;
	private SphericCoordinate sc1;
	
	@Before
	public void setUp() {
		coordinate0 = new CartesianCoordinate(0.0, 0.0, 0.0);
		coordinate1 = new CartesianCoordinate(1.0, 1.0, 1.0);
		coordinate2 = new CartesianCoordinate(1.0, 0.0, 0.0);
		coordinate3 = new CartesianCoordinate(0.0, 0.0, 1.0);
		coordinateNegative = new CartesianCoordinate(-2.0, -3.0, -1.0);
		sc0 = new SphericCoordinate(0.0, 0.0, 1.0);
		sc1 = new SphericCoordinate(0.0, Math.PI/2, 1);
	}
	
	@Test
	public void testDistance() {
		assertEquals(1.0, coordinate0.getDistance(coordinate2), Coordinate.EPSILON);
		assertEquals(Math.sqrt(3.0), coordinate0.getDistance(coordinate1), Coordinate.EPSILON);
		assertEquals(Math.sqrt(2.0), coordinate2.getDistance(coordinate1), Coordinate.EPSILON);
		assertEquals(Math.sqrt(29.0), coordinate1.getDistance(coordinateNegative), Coordinate.EPSILON);
	}
	
	@Test
	public void testEquals() {
		assertEquals(true, coordinate0.equals(new CartesianCoordinate(0.0, 0.0, 0.0)));
		assertEquals(false, coordinate0.equals(coordinate1));
		assertEquals(false, coordinate0.equals(coordinateNegative));
		assertEquals(true, coordinate2.equals(new CartesianCoordinate(1.0, 0.0, 0.0)));
		assertEquals(false, coordinate1.equals(null)); 
		assertEquals(true, sc0.isEqual(coordinate3));
		assertEquals(true, coordinate3.isEqual(sc0));
	}
	
	@Test
	public void testAngle() {
		assertEquals(Math.PI/2, sc0.getCentralAngle(sc1), Coordinate.EPSILON);	
		assertEquals(0.0, sc0.getCentralAngle(coordinate3), Coordinate.EPSILON);
	}
}
