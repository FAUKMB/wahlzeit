/*
 * LegoType
 * 
 * version 1.0
 * 
 * Date: 19.1.19
 * 
 * License: AGPLv3
 */
package org.wahlzeit.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class LegoType {
	protected String typename;
	protected LegoType superType;
	protected Set<LegoType> subTypes = new HashSet<LegoType>();
	protected LegoManager manager = LegoManager.getInstance();
	
	public LegoType(String typename, LegoType superType) {
		manager.addType(typename, this);
		this.typename = typename;
		this.superType = superType;
	}
	
	boolean isSubtype(LegoType sup) {
		if(sup == this) {
			return true;
		}
		LegoType curSup = this;
		while(curSup != null && curSup != sup) {
			curSup = curSup.getSuperType();
		}
		return curSup != null;
	}
	
	public LegoType getSuperType() {
		return superType;
	}
	
	public Iterator<LegoType> getsubTypeIterator(){
		return subTypes.iterator();
	}
	
	public void addSubtype(LegoType type) {
		subTypes.add(type);
	}
	
	public void setSuperType(LegoType sup) {
		superType = sup;
	}
	
	public String getTypename() {
		return typename;
	}
	
	public void setTypename(String typename) {
		this.typename = typename;
	}
}
