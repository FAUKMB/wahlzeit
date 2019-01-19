/*
 * LegoTypeTest
 * 
 * version 1.0
 * 
 * Date: 19.1.19
 * 
 * License: AGPLv3
 */
package org.wahlzeit.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class LegoTypeTest {
	LegoManager manager;
	Lego lego;
	Lego ship;
	Lego starwars;
	@Before
	void setUp(){
		manager = LegoManager.getInstance();
		new LegoType("Lego", null);
		new LegoType("StarWars", manager.getTypeByName("Lego"));
		new LegoType("SpaceShip", manager.getTypeByName("StarWars"));
		lego = new Lego(manager.getTypeByName("Lego"));
		starwars = new Lego(manager.getTypeByName("StarWars"));
		ship = new Lego(manager.getTypeByName("SpaceShip"));
	}
	
	@Test
	void testIsSubtype(){
		assertTrue(ship.getType().isSubtype(lego.getType()));
		assertTrue(ship.getType().isSubtype(starwars.getType()));
		assertFalse(starwars.getType().isSubtype(ship.getType()));
	}
	
}
