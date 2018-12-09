/*
 * LegoPhotoFactory
 * 
 * version 1.0
 * 
 * Date: 11.11.18
 * 
 * License: AGPLv3
 */

package org.wahlzeit.model;

public class LegoPhotoFactory extends PhotoFactory {
	
	/**
	 * @methodtype factory
	 */
	@Override
	public Photo createPhoto(){
		return new LegoPhoto();
	}

	/**
	 * Creates a new photo with the specified id
	 */
	@Override
	public Photo createPhoto(PhotoId id) throws IllegalArgumentException{
		if(id == null) {
			throw new IllegalArgumentException();
		}
		return new LegoPhoto(id);
	}
}
