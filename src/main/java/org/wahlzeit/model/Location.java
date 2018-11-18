/*
 * Location
 * 
 * version 1.0
 * 
 * Date: 30.10.18
 * 
 * License: AGPLv3
 */

package org.wahlzeit.model;

public class Location {
	private Coordinate coordinate;
	
	public Location(Coordinate coordinate) {
		this.coordinate = coordinate;
	}
	
	public Coordinate getCoordinate() {
		return coordinate;
	}
	
	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}
}
