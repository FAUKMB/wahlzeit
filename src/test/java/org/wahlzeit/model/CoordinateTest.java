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
	private Coordinate coordinate0;
	private Coordinate coordinate1;
	private Coordinate coordinate2;
	private Coordinate coordinateNegative;
	static private double delta = 0.0000001;
	
	@Before
	public void setUp() {
		coordinate0 = new Coordinate(0.0, 0.0, 0.0);
		coordinate1 = new Coordinate(1.0, 1.0, 1.0);
		coordinate2 = new Coordinate(1.0, 0.0, 0.0);
		coordinateNegative = new Coordinate(-2.0, -3.0, -1.0);
	}
	
	@Test
	public void testDistance() {
		assertEquals(1.0, coordinate0.getDistance(coordinate2), delta);
		assertEquals(Math.sqrt(3.0), coordinate0.getDistance(coordinate1), delta);
		assertEquals(Math.sqrt(2.0), coordinate2.getDistance(coordinate1), delta);
		assertEquals(Math.sqrt(29.0), coordinate1.getDistance(coordinateNegative), delta);
	}
	
	@Test
	public void testEquals() {
		assertEquals(true, coordinate0.equals(new Coordinate(0.0, 0.0, 0.0)));
		assertEquals(false, coordinate0.equals(coordinate1));
		assertEquals(false, coordinate0.equals(coordinateNegative));
		assertEquals(true, coordinate2.equals(new Coordinate(1.0, 0.0, 0.0)));
		assertEquals(false, coordinate1.equals(null));
	}
	
	
}
