package org.bian.annotation.functionalpattern;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.core.annotation.AliasFor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// TODO: Auto-generated Javadoc
/**
 * The Interface _Configure.
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@RequestMapping(method = RequestMethod.PUT)
@interface _Configure {
	
	/**
	 * Path.
	 *
	 * @return the string[]
	 */
	@AliasFor(annotation = RequestMapping.class)
	String[] path() default {
		"{sd-reference-id}/configuration" };
}
