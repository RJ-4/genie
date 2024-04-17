package com.naehas.genie.exception;

import java.util.List;

/**
 * 
 * Custom exception which can be thrown for an invalid input.
 * 
 * <p>
 * 	Extends java.lang.RuntimeException and uses constructors to define error messages.
 * </p>
 * 
 * <p>
 * 	This exception can be thrown by executing: {@code throw new InvalidInputException("message");} and is not required to be handled or caught.
 * </p>
 * 
 * @author 	Rishabh Jain
 * @see		RuntimeException
 * @since	2nd November 2021
 *
 */
public class InvalidInputException extends RuntimeException {

	private static final long serialVersionUID = -5535617462999781757L		;
	private String logMessage;
	private List<String> errorParameters;

	public InvalidInputException() {
		super();
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
	public InvalidInputException(String errorMessage, String logMessage, List<String> errorParameters) {
		
		super(errorMessage);
		this.logMessage = logMessage;
		this.errorParameters = errorParameters;
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
	public InvalidInputException(String errorMessage, String logMessage) {
		super(errorMessage);
		this.logMessage = logMessage;
	}
	
	/**
	 * Get log message.
	 * 
	 * @return	Log message with information related to error.
	 */
	public String getLogMessage() {
		return logMessage;
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
