package org.wahlzeit.utils;

import java.lang.annotation.Repeatable;

@Repeatable(PatternInstances.class)
public @interface PatternInstance {
	String name();
	String[] participants();
}
