package com.naehas.genie.repository;

import com.naehas.genie.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository layer for operations related to Templates (includes both 
 * {@link com.naehas.workflow.entity.template.StepTemplate step templates} 
 * 		and 
 * {@link com.naehas.workflow.entity.template.WorkflowTemplate workflow templates}).
 * 
 * <p>
 * 	Extends {@code JpaRepository}.
 * 	All the database operations relating to union of step templates and workflow templates are executed from this interface.
 * </p>
 * 
 * <p>
 * 	Inherits {@code JpaRepository} methods with built in functionalities such as {@code save, findAll, findById}.
 * 	It also supports searching by property, and also has built-in support for both paging and sorting. 
 * </p>
 * 
 * @author 	Rishabh Jain
 * @see		JpaRepository
 * @see		com.naehas.workflow.entity.template.StepTemplate
 * @see		com.naehas.workflow.entity.template.WorkflowTemplate
 * @see		com.naehas.workflow.service.template.TemplateService
 * @since	16th November 2021
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	
}
