/*
 * ModelSize
 * 
 * version 1.0
 * 
 * Date: 11.11.18
 * 
 * License: AGPLv3
 */

package org.wahlzeit.model;

/*
 * model size in cm 
 */

public class ModelSize {
	
	private int length;
	private int width;
	private int height;
	
	public ModelSize(int length, int width, int height) {
		this.height = height;
		this.length = length;
		this.width = width;
	}
	
	/**
	 * @methodtype get
	 */
	public int getLength() {
		return length;
	}
	
	/**
	 * @methodtype set
	 */
	public void setLength(int length) {
		this.length = length;
	}
	
	/**
	 * @methodtype get
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * @methodtype set
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	
	/**
	 * @methodtype get
	 */
	public int getHeight() {
		return height;
	}
	
	/**
	 * @methodtype set
	 */
	public void setHeight(int height) {
		this.height = height;
	}
}
