package org.igt.exceptions;

/**
 * Class for custom exception creation which will return response for run time exception.<p>
 * This will help to stop the execution in case of any exception.<p>
 * 
 * Apr 27, 2021
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 */
@SuppressWarnings("serial")
public class FrameworkException extends RuntimeException {
	
	public FrameworkException(String message) {
		super(message); 
	}
	
	public FrameworkException(String message, Throwable cause) { 
		super(message,cause);
	}

}
