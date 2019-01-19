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
	protected Lego lego;
	
	
	public LegoPhoto(){
		super();
	}
	
	public LegoPhoto(PhotoId id) {
		super(id);
	}
	
	public Lego getLego() {
		return lego;
	}
	
	public void setLego(Lego lego) {
		this.lego = lego;
	}
	
}
