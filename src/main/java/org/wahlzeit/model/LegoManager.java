/*
 * LegoManager
 * 
 * version 1.0
 * 
 * Date: 19.1.19
 * 
 * License: AGPLv3
 */
package org.wahlzeit.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.wahlzeit.services.ObjectManager;

public class LegoManager extends ObjectManager{
	private static LegoManager instance;
	private HashMap<String, LegoType> legotypes = new HashMap<String, LegoType>();
	private Set<Lego> legos = new HashSet<Lego>();
	
	public static LegoManager getInstance() {
		if(instance == null) {
			instance = new LegoManager();
		}
		return instance;
	}
	
	private LegoManager() {
		
	}
	
	public LegoType getTypeByName(String name) {
		return legotypes.get(name);
	}
	
	public void addType(String name, LegoType type) {
		if(!legotypes.containsKey(name)) {
			legotypes.put(name, type);
		}
	}
	
	public void addLego(Lego lego) {
		if(lego == null) {
			throw new IllegalArgumentException();
		}
		legos.add(lego);
	}
	
	
}
