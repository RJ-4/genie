package com.naehas.genie.exception;

/**
 * 
 * Custom exception which can be thrown for miscellaneous server exceptions.
 * 
 * <p>
 * 	Extends java.lang.RuntimeException and uses constructors to define error messages.
 * </p>
 * 
 * <p>
 * 	This exception can be thrown by executing: {@code throw new SystemException("message");} and is not required to be handled or caught.
 * </p>
 * 
 * @author 	Rishabh Jain
 * @see		RuntimeException
 * @since	17th May 2022
 *
 */
public class SystemException extends RuntimeException {

	private static final long serialVersionUID = -1256716016781488120L;
	private String logMessage;
	
	public SystemException(String message, Throwable cause) {
		super(message, cause);
	}
	
	/**
	 * Throws InvalidInputException with an error message.
	 * 
	 * @param 	errorMessage
	 * 			Error message which is thrown as part of exception
	 * 
	 * @param 	logMessage
	 * 			Log message is used to get information related to error.
	 */
	public SystemException(String errorMessage, String logMessage) {
		super(errorMessage);
		this.logMessage = logMessage;
	}

	public SystemException(Throwable cause) {
		super(cause);
	}

	/**
	 * Get log message.
	 * 
	 * @return 	Log message contains information related to error.
	 */
	public String getLogMessage() {
		return logMessage;
	}
}
