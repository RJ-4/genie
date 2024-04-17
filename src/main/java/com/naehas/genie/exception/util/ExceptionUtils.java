package com.naehas.genie.exception.util;

import jakarta.validation.ConstraintViolationException;
import java.util.List;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;

/**
 * 
 * Contains utility/helper functions for Exceptions.
 * 
 * @author 	Rishabh Jain
 * @see		MethodArgumentNotValidException
 * @see		jakarta.validation.ConstraintViolationException
 * @since	25th October 2021
 *
 */
public class ExceptionUtils {

	/**
	 * Determines the root cause of MethodArgumentNotValidException and returns its underlying message.
	 * 
	 * @param	exception
	 * 			MethodArgumentNotValidException
	 * 
	 * @return	Root cause error message		
	 */
	public static String getRootCauseMessage(MethodArgumentNotValidException exception) {
		
		List<ObjectError> errors = exception.getAllErrors();
		
		if(errors == null || errors.isEmpty()) {
			return "";
		}
		ObjectError rootCauseError = errors.get(errors.size() - 1);
		
		return rootCauseError.getDefaultMessage();
	}
	
	/**
	 * Determines the root cause of ConstraintViolationException and returns its underlying message.
	 * 
	 * @param	exception
	 * 			ConstraintViolationException
	 * 
	 * @return	Root cause error message		
	 */
	public static String getRootCauseMessage(ConstraintViolationException exception) {
		
		StringBuilder errorMessage = new StringBuilder();
		exception.getConstraintViolations()
				 .forEach(violation -> errorMessage.append(violation.getMessageTemplate()));
		
		return errorMessage.toString();
	}
	
	/**
	 * Fetches stack trace of Exception and returns it.
	 * 
	 * @param 	e
	 * 			Exception for which stack trace is to be fetched.
	 * 
	 * @return	String containing stack trace of the input exception.
	 */
	public static String getStackTrace(Exception e) {
		
		if(e == null) {
			return "";
		}
		
		return org.apache.commons.lang3.exception.ExceptionUtils.getStackTrace(e);
	}
}
