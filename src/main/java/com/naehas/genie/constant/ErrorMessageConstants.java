package com.naehas.genie.constant;

/**
 * Interface containing all the error constant variables and their values and on the base of the value able 
 * to fetch custom error messages from application.properties files.
 * 
 * @author anujkumar
 * @since	26th July 2022
 *
 */
public interface ErrorMessageConstants {

	/**
	 * Generic error message.
	 * 
	 */
	String ERROR_SOMETHING_WENT_WRONG = "error.something-went-wrong";
	
	/**
	 * If value of order by is not asc or desc.
	 * 
	 */
	String ERROR_SORT = "error.sort";
	
	/**
	 * If authentication token is invalid.
	 */
	String ERROR_JWT_INVALID = "error.jwt.invalid";
	
	/**
	 * If jwt does not exist in Authorization header.
	 */
	String ERROR_JWT_DOES_NOT_EXIST = "error.jwt.does-not-exist";
	
	/**
	 * If authentication token has expired.
	 */
	String ERROR_JWT_EXPIRED = "error.jwt.expired";
	
	/**
	 * If subject is missing in jwt.
	 */
	String ERROR_JWT_SUBJECT_MISSING = "error.jwt.subject-missing";
	
	/**
	 * If the session is expired.
	 */
	String ERROR_SESSION_EXPIRED = "error.session.expired";
	
	/**
	 * If no mappings exists for given input step details.
	 */
	String ERROR_INSTANCE_MAPPING_DOES_NOT_EXISTS = "error.instance.mapping.does-not-exists";
	
	/**
	 * If no workflow instance exists for given instance.
	 */
	String ERROR_INSTANCE_WORKFLOW_DOES_NOT_EXISTS = "error.instance.workflow.does-not-exists";
	
	/**
	 * if instance is null while fetching mapping between workflow instance and its step.
	 */
	String ERROR_INSTANCE_REQUIRED = "error.instance.required";
	
	/**
	 * If the template is null or empty.
	 */
	String ERROR_TEMPLATE_INVALID = "error.template.invalid";
	
	/**
	 * If a step template id not found.
	 * 
	 */
	String ERROR_STEP_TEMPLATE_ID_NOT_EXISTS = "error.step.template.id.not-exists";
	
	
	/**
	 * If an Offer with the same name already exists.
	 * 
	 */
	String ERROR_OFFER_TYPE_ID_NOT_EXISTS = "error.offer.type.not-exists";
	
	
	/**
	 * If an Offer with the same name already exists.
	 * 
	 */
	String ERROR_OFFER_ALREADY_EXISTS = "error.offer.already-exists";

	/**
	 * If a File with the same name already exists.
	 *
	 */
	String ERROR_FILE_ALREADY_EXISTS = "error.file.already-exists";
	
	/**
	 * If a File with id does not exist.
	 *
	 */
	String ERROR_FILE_ID_NOT_EXISTS = "error.file.not-exists";
	
	/**
	 * If user facing status already exists.
	 * 
	 */
	String ERROR_STEP_TEMPLATE_STATUS_ALREADY_EXISTS = "error.step.template.status.already-exists";
	
	/**
	 * <li>If internal state of default status is being updated</li>
	 * <li>If default status of default status is being updated</li>
	 */
	String ERROR_STEP_TEMPLATE_STATUS_DEFAULT_UPDATE_NOT_ALLOWED = "error.step.template.status.default.update-not-allowed";
	
	/**
	 * If there does not exist another status for internal state of status
	 * which is either being deleted or whose internal status is being updated.
	 */
	String ERROR_STEP_TEMPLATE_STATUS_INTERNAL_STATE_UPDATE_NOT_ALLOWED = "error.step.template.status.internal.state.update-not-allowed";
	
	/**
	 * If we are making a status as default for which internal status is in-progress and completed 
	 * 
	 */
	String ERROR_STEP_TEMPLATE_STATUS_UPDATE_NOT_ALLOWED = "error.step.template.status.update-not-allowed";
	
	/**
	 * If requested status to delete is a default status.
	 * 
	 */
	String ERROR_STEP_TEMPLATE_STATUS_DEFAULT_DELETE_NOT_ALLOWED = "error.step.template.status.default.delete-not-allowed";
	
	/**
	 * If status does not exists for step type.
	 */
	String ERROR_STEP_TEMPLATE_STATUS_NOT_EXISTS = "error.step.template.status.not-exists";
	
	/**
	 * If no statuses of step types exist for given input ids.
	 */
	String ERROR_STEP_TEMPLATE_STATUSES_INVALID = "error.step.template.statuses.invalid";
	
	/**
	 * If internal state of status is not configurable.
	 */
	String ERROR_STEP_TEMPLATE_INTERNAL_STEP_STATUS_INVALID = "error.step.template.internal.step.status.invalid";
	
	/**
	 * If step template is null or empty for fetching step template status.
	 */
	String ERROR_STEP_TEMPLATE_REQUIRED = "error.step.template.required";
	
	/**
	 * If duration of step template is not defined
	 */
	String ERROR_STEP_TEMPLATE_DURATION_NOT_DEFINED = "error.step.template.duration.not-defined";
	
	/**
	 * If metadata is null or empty and If metadata does not contain mandatory
	 * fields.
	 * 
	 */
	String ERROR_NOTIFICATION_METADATA_NOT_PROVIDED = "error.step.template.status.notification.metadata-not-provided";
	
	/**
	 * If notifications are disabled and metadata is provided.
	 * 
	 */
	String ERROR_STATUS_NOTFICATION_DISABLED = "error.step.template.status.notfication.disabled";
	
	/**
	 * If the name of action button is null or empty.
	 * 
	 */
	String ERROR_STEP_TEMPLATE_ACTION_BUTTON_DETAILS_NOT_DEFINED = "error.step.template.action-button.details-not-defined";
	
	/**
	 * if action button already exists in the step template with the same name.
	 * 
	 */
	String ERROR_STEP_TEMPLATE_ACTION_BUTTON_ALREADY_EXISTS = "error.step.template.action-button.already-exists";
	
	/**
	 * if number of characters is more than max char allowed.
	 * 
	 */
	String ERROR_STEP_TEMPLATE_ACTION_BUTTON_MAX_CHARACTERS_LIMIT = "error.step.template.action-button.max-characters-limit";
	
	/**
	 * If action button does not exists for step type.
	 */
	String ERROR_STEP_TEMPLATE_ACTION_BUTTON_NOT_EXISTS = "error.step.template.action-button.not-exists";
	
	/**
	 * If step instance details are updated after it is marked as completed.
	 * 
	 */
	String ERROR_STEP_INSTANCE_UPDATE_NOT_ALLOWED_AFTER_COMPLETION = "error.step.instance.update-not-allowed-after-completion";
	
	/**
	 * If due date of step instance is less than its start date.
	 * 
	 */
	String ERROR_STEP_INSTANCE_DUE_DATE_LESS_THAN_START_DATE = "error.step.instance.due-date-less-than-start-date";
	
	/**
	 * If a step instance id is not found.
	 * 
	 */
	String ERROR_STEP_INSTANCE_ID_NOT_EXISTS = "error.step.instance.id.not-exists";
	
	/**
	 * If the status does not exist for the step instance.
	 */
	String ERROR_STEP_INSTANCE_STATUS_NOT_EXISTS = "error.step.instance.status.not-exists";
	
	/**
	 * If the status does not exist for the step instance.
	 */
	String ERROR_STEP_INSTANCE_STATUS_NAME_NOT_EXISTS = "error.step.instance.status.name.not-exists";
	
	/**
	 * If a workflow template with the same name already exists.
	 * 
	 */
	String ERROR_WORKFLOW_TEMPLATE_ALREADY_EXISTS = "error.workflow.template.already-exists";
	
	/**
	 * If workflow template with id does not exist.
	 * 
	 */
	String ERROR_WORKFLOW_TEMPLATE_ID_NOT_DEFINED = "error.workflow.template.id.not-defined";
	
	/**
	 * If events for input workflow template are already not defined.
	 * 
	 */
	String ERROR_WORKFLOW_TEMPLATE_EVENTS_NOT_DEFINED = "error.workflow.template.events-not-defined";
	
	/**
	 * If events for input workflow template are already defined.
	 * 
	 */
	String ERROR_WORKFLOW_TEMPLATE_EVENTS_ALREADY_EXIST = "error.workflow.template.events-already-exist";
	
	/**
	 * If no source step is marked as first step in all of the events.
	 * 
	 */
	String ERROR_WORKFLOW_TEMPLATE_EVENT_FIRST_STEP_NOT_DEFINED = "error.workflow.template.event.first-step-not-defined";
	
	/**
	 * If no destination step is marked as last step in all of the events.
	 * 
	 */
	String ERROR_WORKFLOW_TEMPLATE_EVENT_LAST_STEP_NOT_DEFINED = "error.workflow.template.event.last-step-not-defined";
	
	/**
	 * If the input step is a gateway, and its rule is null.
	 * 
	 */
	String ERROR_WORKFLOW_TEMPLATE_EVENT_GATEWAY_RULE_NOT_DEFINED = "error.workflow.template.event.gateway-rule-not-defined";
	
	/**
	 * If user facing status already exists.
	 * 
	 */
	String ERROR_WORKFLOW_TEMPLATE_STATUS_ALREADY_EXISTS = "error.workflow.template.status.already-exists";
	
	/**
	 * If status dose not exists for workflow template.
	 */
	String ERROR_WORKFLOW_TEMPLATE_STATUS_NOT_EXISTS = "error.workflow.template.status.not-exists";
	
	/**
	 * If workflow configurations were missing.
	 * 
	 */
	String ERROR_WORKFLOW_INSTANCE_EVENTS_NOT_FOUND = "error.workflow.instance.events-not-found";
	
	/**
	 * If dueDate of workflow instance is before the input startDate.
	 * 
	 */
	String ERROR_WORKFLOW_INSTANCE_DUE_DATE_LESS_THAN_START_DATE = "error.workflow.instance.due-date-less-than-start-date";
	
	/**
	 * If number of days between input start date and due date is not equal to
	 * corresponding workflow template's duration.
	 * 
	 */
	String ERROR_WORKFLOW_INSTANCE_DUE_DATE = "error.workflow.instance.due-date";
	
	/**
	 * If the internal status of current status is closed.
	 * 
	 */
	String ERROR_WORKFLOW_UPDATE_NOT_ALLOWED = "error.workflow.update-not-allowed";
	
	/**
	 * If error occurs creating InputStream from generated report file.
	 * 
	 */
	String ERROR_WORKFLOW_INSTANCE_REPORT_DOWNLOAD = "error.workflow.instance.report.download";
	
	/**
	 * If error occurs running job to create excel report.
	 * 
	 */
	String ERROR_WORKFLOW_INSTANCE_REPORT_GENERATE = "error.workflow.instance.report.generate";
	
	/**
	 * If workflow instance with id does not exist.
	 * 
	 */
	String ERROR_WORKFLOW_INSTANCE_ID_NOT_DEFINED = "error.workflow.instance.id.not-defined";
	
	/**
	 * If the filter fields contains invalid field name.
	 * 
	 */
	String ERROR_WORKFLOW_INSTANCE_INVALID_FILTER = "error.workflow.instance.invalid-filter";
	
	/**
	 * If there is an error flushing data to excel file.
	 */
	String ERROR_WORKFLOW_INSTANCE_REPORT_INVALID_WRITE = "error.workflow.instance.report.invalid-write";
	
	/**
	 * If step template from events is deleted and user tries to initialize a workflow.
	 */
	String ERROR_WORKFLOW_INSTANCE_CANNOT_BE_CREATED = "error.workflow.instance.cannot-be-created";

	/**
	 * If step instance with given id does not exist in workflow instance with given workflow instance id.
	 */
	String ERROR_STEP_INSTANCE_WITH_ID_DOES_NOT_EXIST_IN_WORKFLOW_INSTANCE = "error.step.instance.id.not-exists-in-workflow-instance";
	
	/**
	 * If delegate is enabled for a user but delegate user's id is null.
	 */
	String ERROR_DELEGATE_ID_NOT_DEFINED = "error.delegate.id-not-defined";
	
	/**
	 * If filter view with same name already exists while saving.
	 */
	String ERROR_FILTER_VIEW_ALREADY_EXISTS = "error.workflow.instances.filter-view.exists";

	/**
     * If filter view does not exist in the workflow instance.
     */
    String ERROR_FILTER_VIEW_DOES_NOT_EXIST = "error.workflow.instances.filter-view.id.not-defined";

    /**
     * If attached file requested version is not found.
     */
    String ERROR_ATTACHED_FILE_VERSION_HISTORY_NOT_FOUND = "error.attachment.version.not-found";

    /**
     * If attached file requested is not found for step instance.
     */
    String ERROR_ATTACHED_FILE_NOT_FOUND = "error.attachment.not-found";

    /**
     * If attachment folder for any step instance is not found
     */
    String ERROR_STEP_INSTANCE_ATTACHMENT_FOLDER_NOT_FOUND = "error.step.instance.attachment-folder.not-found";
}
