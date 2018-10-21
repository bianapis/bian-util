package org.bian.annotation.functionalpattern;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// TODO: Auto-generated Javadoc
/**
 * The Interface Maintain.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Maintain {
	
	/**
	 * The Interface Activate.
	 */
	// Origination ---
	@Retention(RetentionPolicy.RUNTIME)
	@_Activate @interface Activate {}

	/**
	 * The Interface Configure.
	 */
	@Retention(RetentionPolicy.RUNTIME)
	@_Configure @interface Configure {}
	// ---

	/**
	 * The Interface Record.
	 */
	// Invocation ---
	@Retention(RetentionPolicy.RUNTIME)
	@_Record @interface Record {}

	/**
	 * The Interface RequestPost.
	 */
	@Retention(RetentionPolicy.RUNTIME)
	@_RequestPost @interface RequestPost {}

	/**
	 * The Interface RequestPut.
	 */
	@Retention(RetentionPolicy.RUNTIME)
	@_RequestPut @interface RequestPut {}
	
	/**
	 * The Interface Retrieve.
	 */
	// Reporting ---
	@Retention(RetentionPolicy.RUNTIME)
	@_Retrieve @interface Retrieve {}
	
	/**
	 * The Interface RetrieveRefIds.
	 */
	@Retention(RetentionPolicy.RUNTIME)
	@_RetrieveRefIds @interface RetrieveRefIds {}
	
	/**
	 * The Interface RetrieveBQs.
	 */
	@Retention(RetentionPolicy.RUNTIME)
	@_RetrieveBQs @interface RetrieveBQs {}
	
	/**
	 * The Interface RetrieveBQIds.
	 */
	@Retention(RetentionPolicy.RUNTIME)
	@_RetrieveBQIds @interface RetrieveBQIds {}
	// ---
	
}
