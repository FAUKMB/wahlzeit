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
	
	/*
	 * Precondition: none
	 * 
	 * Postcondition: returns a CartesianCoordinate that fulfills the class invariants
	 * and the Coordinate is not modified
	 */
	public CartesianCoordinate asCartesianCoordinate();
	
	/*
	 * Precondition: c is not null
	 * 
	 * Postcondition: returns the distance to the given coordinate c
	 * and the Coordinate is not modified
	 */
	public double getCartesianDistance(Coordinate c);
	
	/*
	 * Precondition: none
	 * 
	 * Postcondition: returns a equivalent SphericCoordinate that fulfills the class invariants
	 * and the Coordinate is not modified
	 */
	public SphericCoordinate asSphericCoordinate();
	
	/*
	 * Precondition: c is not null and not (0,0,0) or a SphericCoordinate equivalent to (0,0,0)
	 * 
	 * Postcondition: returns the central angle and the Coordinate is not modified
	 */
	public double getCentralAngle(Coordinate c);
	
	/*
	 * Precondition: c is not null
	 * 
	 * Postcondition: returns true if the Coordinate and c are equal otherwise false
	 */
	public boolean isEqual(Coordinate c);
}
