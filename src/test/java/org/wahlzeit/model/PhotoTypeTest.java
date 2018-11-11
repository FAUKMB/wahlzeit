/*
 * PhotoTypeTest
 * 
 * version 1.0
 * 
 * Date: 11.11.18
 * 
 * License: AGPLv3
 */

package org.wahlzeit.model;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

public class PhotoTypeTest {
	
	@Test
	public void typeTest() {
		Photo p = PhotoFactory.getInstance().createPhoto();
		assertTrue(p instanceof LegoPhoto);
		assertTrue(PhotoManager.getInstance() instanceof LegoPhotoManager);
		assertTrue(PhotoFactory.getInstance() instanceof LegoPhotoFactory);
		assertTrue(PhotoManager.getInstance().getPhoto(PhotoId.getFromInt(PhotoId.getCurrentIdAsInt())) instanceof LegoPhoto);
	}
}
