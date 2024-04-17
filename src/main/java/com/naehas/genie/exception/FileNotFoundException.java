package com.naehas.genie.exception;

import lombok.NoArgsConstructor;

/**
 * Custom exception which can be thrown for when file is not found for input parameter(s).
 * 
 * <p>
 * 	Extends java.lang.RuntimeException and uses constructors to define error messages.
 * </p>
 * 
 * <p>
 * 	This exception can be thrown by executing: {@code throw new FileNotFoundException("errorMessage","message");} and is not required to be handled or caught.
 * </p>
 * 
 * @author 	Sahil Gupta
 * @see		RuntimeException
 * @since	16th Oct 2022
 * 
 */
@NoArgsConstructor
public class FileNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 8162334409219032404L;
	private String logMessage;
	
	
	public FileNotFoundException(String errorMessage, String logMessage) {
		super(errorMessage);
		this.logMessage = logMessage;
	}

	public String getLogMessage() {
		return this.logMessage;
	}
	
}
