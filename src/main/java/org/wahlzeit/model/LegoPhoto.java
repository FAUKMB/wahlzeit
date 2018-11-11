/*
 * LegoPhoto
 * 
 * version 1.0
 * 
 * Date: 11.11.18
 * 
 * License: AGPLv3
 */

package org.wahlzeit.model;

public class LegoPhoto extends Photo {
	
	protected int pieceCount;
	protected int buildTime;
	protected int weight;
	protected ModelSize size;
	
	public LegoPhoto() {
		super();
	}
	
	public LegoPhoto(PhotoId id) {
		super(id);
	}
	
	/**
	 * @methodtype get
	 */
	public int getPieceCount() {
		return pieceCount;
	}
	
	/**
	 * @methodtype set
	 */
	public void setPieceCount(int pieceCount) {
		this.pieceCount = pieceCount;
	}
	
	/**
	 * @methodtype get
	 */
	public int getBuildTime() {
		return buildTime;
	}
	
	/**
	 * @methodtype set
	 */
	public void setBuildTime(int buildTime) {
		this.buildTime = buildTime;
	}
	
	/**
	 * @methodtype get
	 */
	public int getWeight() {
		return weight;
	}
	
	/**
	 * @methodtype set
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	/**
	 * @methodtype get
	 */
	public ModelSize getSize() {
		return size;
	}
	
	/**
	 * @methodtype set
	 */
	public void setSize(ModelSize size) {
		this.size = size;
	}

	
}
