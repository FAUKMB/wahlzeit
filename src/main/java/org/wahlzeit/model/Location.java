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
	private CartesianCoordinate coordinate;
	
	public Location(CartesianCoordinate coordinate) {
		this.coordinate = coordinate;
	}
	
	public CartesianCoordinate getCoordinate() {
		return coordinate;
	}
	
	public void setCoordinate(CartesianCoordinate coordinate) {
		this.coordinate = coordinate;
	}
}
