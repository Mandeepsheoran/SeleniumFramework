package org.igt.exceptions;

/**
 * To declare custom exception methods for property file related usage.<p> 
 * This will extend main custom exception handling class (@link FrameworkException).
 * Apr 27, 2021
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 * @see FrameworkException
 */
@SuppressWarnings("serial")
public class PropertyFileUsageException extends FrameworkException {
	
	
		public PropertyFileUsageException(String message) {
			super(message);
		}

		public PropertyFileUsageException(String message,Throwable cause) {
			super(message,cause);
		}
	}



