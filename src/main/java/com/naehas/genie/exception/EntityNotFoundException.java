package com.naehas.genie.exception;

import java.util.List;

/**
 * Custom exception which can be thrown for when entity is not found for input parameter(s).
 * 
 * <p>
 * 	Extends java.lang.RuntimeException and uses constructors to define error messages.
 * </p>
 * 
 * <p>
 * 	This exception can be thrown by executing: {@code throw new EntityNotFoundException("message");} and is not required to be handled or caught.
 * </p>
 * 
 * @author 	Rishabh Jain
 * @see		RuntimeException
 * @since	9th November 2021
 * 
 */
public class EntityNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 8162334409219032404L;
	private String logMessage;
	private List<String> errorParameters;
	
	public EntityNotFoundException() {
	}

	/**
	 * Throws InvalidInputException with an error message.
	 * 
	 * @param 	errorMessage
	 * 			Error message to be shown to user when this exception is thrown.
	 * 
	 * @param 	logMessage
	 * 			Error message to be logged by the application in application logs.
	 */
	public EntityNotFoundException(String errorMessage, String logMessage) {
		super(errorMessage);
		this.logMessage = logMessage;
	}
	
	/**
	 * Throws InvalidInputException with an error message.
	 * 
	 * @param 	errorMessage
	 * 			Error message to be shown to user when this exception is thrown.
	 * 
	 * @param 	logMessage
	 * 			Error message to be logged by the application in application logs.
	 * 
	 * @param   errorParameters
	 * 			Error parameters contain data which is required in user-facing error messages to provide user more 
	 *          meaningful error messages like name, id etc.
	 *          
	 */
	public EntityNotFoundException(String errorMessage, String logMessage, List<String> errorParameters) {
		super(errorMessage);
		this.logMessage = logMessage;
		this.errorParameters = errorParameters;
	}
	
	/**
	 * Get log message.
	 * 
	 * @return 	Error message to be logged by the application in application logs.
	 */
	public String getLogMessage() {
		return this.logMessage;
	}
	
	/**
	 * Get error parameters.
	 * 
	 * @return 	Error parameters contain data which is required in user-facing messages like name, id etc.
	 */
	public List<String> getErrorParameters() {
		return this.errorParameters;
	}
}
