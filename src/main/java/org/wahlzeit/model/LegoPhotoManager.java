/*
 * LegoPhotoManager
 * 
 * version 1.0
 * 
 * Date: 11.11.18
 * 
 * License: AGPLv3
 */

package org.wahlzeit.model;

public class LegoPhotoManager extends PhotoManager {
	
	public LegoPhotoManager() {
		photoTagCollector = LegoPhotoFactory.getInstance().createPhotoTagCollector();
	}
	
	@Override
	public Photo getPhotoFromId(PhotoId id) {
		if (id == null) {
			return null;
		}

		Photo result = doGetPhotoFromId(id);

		if (result == null) {
			result = LegoPhotoFactory.getInstance().loadPhoto(id);
			if (result != null) {
				doAddPhoto(result);
			}
		}

		return result;
	}
}
