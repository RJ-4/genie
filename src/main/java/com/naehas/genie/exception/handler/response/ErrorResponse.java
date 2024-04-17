package com.naehas.genie.exception.handler.response;

import java.io.Serializable;
import lombok.*;

/**
 * 
 * Model for API error responses sent by the application.
 * 
 * <p>
 * 	Represents structure/list of properties which will be sent as API response in case an exception is thrown.
 * 	This class is only supposed to be used and initialized by {@code GlobalExceptionHandler}.
 * </p>
 * 
 * @author 	Rishabh Jain
 * @see		com.naehas.workflow.exception.handler.GlobalExceptionHandler
 * 
 * @since	25th October 2021
 *
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ErrorResponse implements Serializable {

	private static final long serialVersionUID = 5736109107470197064L;
	
	/**
	 * Error message to be send to front-end. This message will be shown to users if exception is thrown.
	 */
	private String errorMessage;
}
