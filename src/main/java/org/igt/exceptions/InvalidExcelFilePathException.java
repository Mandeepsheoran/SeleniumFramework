package org.igt.exceptions;

/**
 * Class to declare custom exception for invalid file path.<p>
 * This will entend main custom exception class (@link FrameworkException)
 * Apr 27, 2021
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 * @see FrameworkException
 */
@SuppressWarnings("serial")
public class InvalidExcelFilePathException extends FrameworkException {  //This class is created to implement exception specific class like we also created one for ReadProperty file exception
	
	public InvalidExcelFilePathException(String message) {
		super(message);
	}

	public InvalidExcelFilePathException(String message,Throwable cause) {
		super(message,cause);
	}
}
