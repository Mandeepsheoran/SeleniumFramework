package org.igt.customannotations;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.igt.enums.CategoryType;
/**
 * Interface to create custom annotation which will be used in framework while working with extent report content.<p>
 * 
 * Apr 27, 2021
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 */
@Retention(RUNTIME)
@Target(METHOD)   
public @interface FrameworkAnnotations {	
	public String author();    
	public CategoryType[] category();
	public String osinfo();
}
