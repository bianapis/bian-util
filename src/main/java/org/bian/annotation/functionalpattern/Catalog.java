package org.bian.annotation.functionalpattern;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// TODO: Auto-generated Javadoc
/**
 * The Interface Catalog.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Catalog {

// ***** SD Operation *****
	
	/**
	 * The Interface Activate.
	 */
	@Retention(RetentionPolicy.RUNTIME)
	@_Activate @interface Activate {}

	/**
	 * The Interface Configure.
	 */
	@Retention(RetentionPolicy.RUNTIME)
	@_Configure @interface Configure {}
	
	/**
	 * The Interface Feedback.
	 */
	@Retention(RetentionPolicy.RUNTIME)
	@_Feedback @interface Feedback {}
	
// ***** ----- *****

	
// ***** Control Record Instantiation *****

	/**
	 * The Interface Register.
	 */
	@Retention(RetentionPolicy.RUNTIME)
	@_Register @interface Register {}

// ***** ----- *****


// ***** Control Record Invocation *****

	/**
	 * The Interface Update.
	 */
	@Retention(RetentionPolicy.RUNTIME)
	@_Update @interface Update {}
	
	/**
	 * The Interface Control.
	 */
	@Retention(RetentionPolicy.RUNTIME)
	@_Control @interface Control {}
	
	/**
	 * The Interface Exchange.
	 */
	@Retention(RetentionPolicy.RUNTIME)
	@_Exchange @interface Exchange {}
	
	/**
	 * The Interface Execute.
	 */
	@Retention(RetentionPolicy.RUNTIME)
	@_Execute @interface Execute {}
	
	/**
	 * The Interface Request.
	 */
	@Retention(RetentionPolicy.RUNTIME)
	@_Request @interface Request {}

// ***** ----- *****

	
// ***** Reporting *****
	
	/**
	 * The Interface Notify.
	 */
	@Retention(RetentionPolicy.RUNTIME)
	@_Notify @interface Notify {}

	/**
	 * The Interface Retrieve.
	 */
	@Retention(RetentionPolicy.RUNTIME)
	@_Retrieve @interface Retrieve {}

	/**
	 * The Interface RetrieveSD.
	 */
	@Retention(RetentionPolicy.RUNTIME)
	@_RetrieveSD @interface RetrieveSD {}
	
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
	
// ***** ----- *****
	
}
