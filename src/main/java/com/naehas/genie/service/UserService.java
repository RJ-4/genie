package com.naehas.genie.service;

import com.naehas.genie.dto.request.UserRequestDTO;
import com.naehas.genie.dto.response.UserResponseDTO;
import com.naehas.genie.entity.User;
import com.naehas.genie.exception.EntityNotFoundException;
import com.naehas.genie.exception.InvalidInputException;

/**
 * Service layer for operations related to step templates.
 * 
 * <p>
 * 	All the business logic for operations pertaining to step template is performed by implementations of this interface.
 * </p>
 * 
 * <p>
 * 	Implementation(s) of this interface receive request from {@code StepTemplateController} 
 *  and interact with database layer i.e., {@code StepTemplateRepository} to perform operations on database.
 * </p>
 * 
 * @author 	Piyush Kapoor
 * @see		com.naehas.genie.service.impl.template.StepTemplateServiceImpl
 * @see		com.naehas.genie.entity.template.StepTemplate
 * @see		com.naehas.genie.controller.template.StepTemplateController
 * @see		com.naehas.genie.repository.template.StepTemplateRepository
 * @since	22nd October 2021
 *
 */
public interface UserService {

	/**
	 * Creates and saves a new step template to the database.
	 * 
	 * @param 	stepTemplateRequestDto
	 * 			List of step template configurations.
	 *
	 * @return 	List of created step template configurations.
	 * 
	 * @throws	InvalidInputException
	 * 			<li>
	 * 				If a step template with the input name already exists
	 * 			</li>
	 */
	UserResponseDTO createUser(UserRequestDTO userRequestDto) throws InvalidInputException;
	
	/**
	 * Update the step template with input id.
	 * 
	 * <p>
	 * 	Supports update of step template's basic data fields and does not support update of step template status.
	 * </p>
	 * 
	 * @param 	id
	 * 			Id of the step template to be updated.
	 * 
	 * @param 	userRequestDto
	 * 			Properties of the step template to be updated.
	 *
	 * @return	Updated step template's configurations.
	 *  
	 * @throws 	EntityNotFoundException
	 * 			If step template with input {@code id} is not found.
	 * 
	 * @throws 	InvalidInputException  
	 * 			If a step template already exists with the updated name.
	 *
	 * @throws 	SystemException
	 * 			If there is an error fetching the results from Future object.
	 */
	/*UserResponseDTO updateUser(Long id, UpdateUserRequestDTO userRequestDto)
																	throws EntityNotFoundException,
																		   InvalidInputException,
																           SystemException;*/
	/**
	 * Fetches a step template with input {@code id}.
	 * 
	 * @param 	id
	 * 			Id of the step template to be fetched.
	 * 
	 * @return	Instance of the {@code StepTemplate}.
	 * 
	 * @throws 	EntityNotFoundException
	 * 			If step template with input {@code id} is not found.
	 */
	User findById(Long id) throws EntityNotFoundException;
	
	/**
	 * Soft deletes a step template with input {@code id}.
	 * 
	 * @param 	id
	 * 			Id of the step template to be deleted.
	 *
	 * @throws 	EntityNotFoundException
	 * 			If step template with input {@code id} is not found.
	 */
	void deleteUser(Long id) throws EntityNotFoundException;

}
