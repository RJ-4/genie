package com.naehas.genie.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 * @author Rishabh
 * @since 2nd September 2021
 *
 */
@ResponseStatus(code = HttpStatus.FORBIDDEN)
public class InvalidJwtException extends RuntimeException {

	private static final long serialVersionUID = 8002913012436105749L;
	private String logMessage;
	
	/**
	 * Throws InvalidJwtException with an error message.
	 * 
	 * @param 	errorMessage
	 * 			Error message which is thrown as part of exception
	 * 
	 * @param 	logMessage
	 * 			Log message is used to get information related to error.
	 */
	public InvalidJwtException(String errorMessage, String logMessage) {
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

}
