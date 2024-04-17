package com.naehas.genie.exception.handler;

import com.naehas.genie.exception.*;
import com.naehas.genie.exception.handler.response.ErrorResponse;
import com.naehas.genie.exception.util.ExceptionUtils;
import jakarta.validation.ConstraintViolationException;
import java.util.List;
import java.util.Locale;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * 
 * Common handler for all exceptions thrown in the application.
 * 
 * <p>
 * 	This class handles all exceptions, populates custom API error response model and returns it as part of API response.
 * </p>
 * 
 * @author 	Rishabh Jain
 * @see		com.naehas.genie.exception.handler.response.ErrorResponse
 * @see		com.naehas.genie.exception.util.ExceptionUtils
 * @see		ResponseEntityExceptionHandler
 * 
 * @since	25th October 2021
 *
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@Autowired
	private MessageSource messageSource;
	
	/**
	 * Handles InvalidInputException.
	 * 
	 * <p>
	 * 	This exception handler is triggered when an {@link com.naehas.genie.exception.InvalidInputException InvalidInputException} is thrown.
	 * </p>
	 * 
	 * @param 	e
	 * 			Instance of {@code InvalidInputException}
	 * 
	 * @return	List of parameters defined in {@code ErrorResponse} as API response along with a HTTP status code
	 */
	@ExceptionHandler({InvalidInputException.class})
	public ResponseEntity<ErrorResponse> handleInvalidInputException(InvalidInputException e) {
		String errorMessage = messageSource.getMessage(e.getMessage(), null, Locale.ENGLISH);
		String logMessage = e.getLogMessage();
		List<String> errorParameters = e.getErrorParameters();
		
		if(!CollectionUtils.isEmpty(errorParameters)) {
			errorMessage = String.format(errorMessage, errorParameters.toArray());
		}
		
		log.error("Handling InvalidInputException with message: " + logMessage);
		
		ErrorResponse errorResponse = ErrorResponse.builder()
												   .errorMessage(errorMessage)
												   .build();
		
		log.error("Successfully handled InvalidInputException and returning response with message: " + errorMessage);
		
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
	

	
	/**
	 * Handles {@code EntityNotFoundException}.
	 * 
	 * <p>
	 * 	This exception handler is triggered when an {@link EntityNotFoundException EntityNotFoundException} is thrown.
	 * </p>
	 * 
	 * @param 	e
	 * 			Instance of {@code EntityNotFoundException}
	 * 
	 * @return	List of parameters defined in {@code ErrorResponse} as API response along with a HTTP status code
	 */
	@ExceptionHandler({EntityNotFoundException.class})
	public ResponseEntity<ErrorResponse> handleEntityNotFoundException(EntityNotFoundException e) {
	
		String errorMessage = messageSource.getMessage(e.getMessage(), null, Locale.ENGLISH);
		String logMessage = e.getLogMessage();
		List<String> errorParameters = e.getErrorParameters();
		
		if(!CollectionUtils.isEmpty(errorParameters)) {
			errorMessage = String.format(errorMessage, errorParameters.toArray());
		}
		
		log.error("Handling EntityNotFoundException with message: " + logMessage);
		
		ErrorResponse errorResponse = ErrorResponse.builder()
												   .errorMessage(errorMessage)
												   .build();
		
		log.error("Successfully handled EntityNotFoundException and returning response with message: " + errorMessage);
		
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
	/**
	 * Handles SystemException.
	 * 
	 * <p>
	 * 	This exception handler is triggered when an {@link com.naehas.genie.exception.SystemException SystemException} is thrown.
	 * </p>
	 * 
	 * @param 	e
	 * 			Instance of {@code SystemException}
	 * 
	 * @return	List of parameters defined in {@code ErrorResponse} as API response along with a HTTP status code
	 */
	@ExceptionHandler({SystemException.class})
	public ResponseEntity<ErrorResponse> handleSystemException(SystemException e) {
		
		String errorMessage = messageSource.getMessage(e.getMessage(), null, Locale.ENGLISH);
		String logMessage = e.getLogMessage();
		log.error("Handling SystemException with message: " + logMessage);
		
		ErrorResponse errorResponse = ErrorResponse.builder()
												   .errorMessage(errorMessage)
												   .build();
		
		log.error("Successfully handled SystemException and returning response with message: " + errorMessage);
		
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
	
	/**
	 * Handles NumberFormatException.
	 * 
	 * <p>
	 * 	This exception handler is triggered when an {@link NumberFormatException NumberFormatException} is thrown.
	 * </p>
	 * 
	 * @param 	e
	 * 			Instance of {@code NumberFormatException}
	 * 
	 * @return	List of parameters defined in {@code ErrorResponse} as API response along with a HTTP status code
	 */
	@ExceptionHandler({NumberFormatException.class})
	public ResponseEntity<ErrorResponse> handleNumberFormatException(NumberFormatException e) {
		
		String errorMessage = e.getMessage();
		
		log.error("Handling NumberFormatException with message: " + errorMessage);
		
		ErrorResponse errorResponse = ErrorResponse.builder()
												   .errorMessage(errorMessage)
												   .build();
		
		log.error("Successfully handled NumberFormatException and returning response with message: " + errorMessage);
		
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}

	
	/**
	 * Handles {@code ConstraintViolationException}.
	 * 
	 * <p>
	 * 	This exception handler handles exceptions generated from API input request body validation parameters.
	 * 	Validations failed from {@Pattern} throw ConstraintViolationException.
	 * </p>
	 * 
	 * @param 	exception
	 * 			Instance of {@code ConstraintViolationException}
	 * 
	 * @return	List of parameters defined in {@code ErrorResponse} as API response along with a HTTP status code
	 */
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException exception) {
			
		String errorMessage = ExceptionUtils.getRootCauseMessage(exception);
		
		log.error("Handling ConstraintViolationException with message: " + errorMessage);
		
		ErrorResponse errorResponse = ErrorResponse.builder()
												   .errorMessage(errorMessage.toString())
												   .build();
		
		log.error("Returning ConstraintViolationException response with message: " + errorMessage);
		
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
	
	/**
	 * Handles {@code UniqueConstraintException}.
	 * 
	 * <p>
	 * 	This exception handler handles exceptions generated from API input request body validation parameters.
	 * 	Validations failed from {@code UniqueConstraint} throw {@link DataIntegrityViolationException}.
	 * </p>
	 * 
	 * @param 	exception
	 * 			Instance of {@code UniqueConstraintException}
	 * 
	 * @return	List of parameters defined in {@code ErrorResponse} as API response along with a HTTP status code
	 */
	@ExceptionHandler(UniqueConstraintException.class)
	public ResponseEntity<Object> handleUniqueConstraintViolationException(UniqueConstraintException exception) {
			
		String errorMessage = exception.getLogMessage();
		
		log.error("Handling UniqueContraintException with message: " + errorMessage);
		
		ErrorResponse errorResponse = ErrorResponse.builder()
												   .errorMessage(errorMessage.toString())
												   .build();
		
		log.error("Returning UniqueContraintException response with message: " + errorMessage);
		
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
	
	
	/**
	 * Handles {@cod FileNotFoundException}.
	 * 
	 * <p>
	 * 	This exception handler handles the expectations generated from API, when requested file is not found in the system.
	 * </p>
	 * 
	 * @param 	exception
	 * 			Instance of {@code FileNotFoundException}
	 * 
	 * @return	List of parameters defined in {@code ErrorResponse} as API response along with a HTTP status code
	 */
	@ExceptionHandler(FileNotFoundException.class)
	public ResponseEntity<Object> handleFileNotFoundException(FileNotFoundException exception){
		
		String errorMessage = messageSource.getMessage(exception.getMessage(), null, Locale.ENGLISH);
		String logMessage = exception.getLogMessage();
		
		log.error("Handling FileNotFoundException with message: " + logMessage);
		
		ErrorResponse errorResponse = ErrorResponse.builder()
												   .errorMessage(errorMessage.toString())
												   .build();
		
		log.error("Returning FileNotFoundException response with message: " + errorMessage);
		
		return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	/**
	 * Handles unexpected exceptions.
	 * 
	 * <p>
	 * 	This exception handler is triggered when an exception is thrown by the application which belongs to {@code java.lang.Exception}
	 * 	or its subclasses, for which there is no specific exception handler defined in this class.
	 * </p>
	 * 
	 * <p>
	 * 	For example, if the program throws an {@link com.naehas.genie.exception.InvalidInputException InvalidInputException},
	 *  then this handler is not triggered because there is an an exception handler explicitly defined for that.
	 * </p>
	 * 
	 * @param 	e
	 * 			Instance of {@code java.lang.Exception}
	 * 
	 * @return	List of parameters defined in {@code ErrorResponse} as API response along with a HTTP status code
	 */
	@ExceptionHandler({Exception.class})
	public ResponseEntity<ErrorResponse> handleException(Exception e) {
		
		log.error("Handling unknown exception: " + e);
		e.printStackTrace();
		log.error("Stack trace: " + ExceptionUtils.getStackTrace(e));
		
		String errorMessage = "Something went wrong, please try again. If the issue persists, please contact support!";
		ErrorResponse errorResponse = ErrorResponse.builder()
												   .errorMessage(errorMessage)
												   .build();
		
		log.error("Successfully handled unknown exception. Returning response with message: " + errorMessage);
		
		return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
