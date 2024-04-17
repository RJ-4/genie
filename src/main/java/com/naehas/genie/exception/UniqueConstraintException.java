package com.naehas.genie.exception;

/**
 * Custom exception which can be thrown for when any unique constraint on entity is violated.
 * 
 * <p>
 * 	Extends java.lang.RuntimeException and uses constructors to define error messages.
 * </p>
 * 
 * <p>
 * 	This exception can be thrown by executing: {@code throw new UniqueContraintException("message");} and is not required to be handled or caught.
 * </p>
 * 
 * @author 	Sahil Gupta
 * @see		RuntimeException
 * @since	3rd October 2022
 *
 */
public class UniqueConstraintException extends RuntimeException {

	private static final long serialVersionUID = -4982849635600309428L;

	private String logMessage;
	
	public UniqueConstraintException() {}

	public UniqueConstraintException(String logMessage) {
		super();
		this.logMessage = logMessage;
	}
	
	/**
	 * Throws UniqueContraintException with an error message.
	 * 
	 * @param 	errorMessage
	 * 			Error message to be shown to user when this exception is thrown.
	 * 
	 * @param 	logMessage
	 * 			Error message to be logged by the application in application logs.
	 */
	public UniqueConstraintException(String errorMessage, String logMessage) {
		super(errorMessage);
		this.logMessage = logMessage;
	}
	
	/**
	 * Get log message.
	 * 
	 * @return 	Error message to be logged by the application in application logs.
	 */
	public String getLogMessage() {
		return this.logMessage;
	}
}
