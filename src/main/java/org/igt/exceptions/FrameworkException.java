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
		super(message); // This is to pass exception to parent exception calss i.e. RuntimeException because we want to stop the execution
	}
	
	public FrameworkException(String message, Throwable cause) {  // This is also constructor in case if user want to send cause message also
		super(message,cause);
	}

}
