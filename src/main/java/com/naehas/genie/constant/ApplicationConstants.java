package com.naehas.genie.constant;

/**
 * Interface containing all the constant variables and their values used in the business logic of the application.
 * 
 * @author 	Rishabh Jain
 * @since	16th March 2022
 *
 */
public interface ApplicationConstants {

	/**
	 * Id of the system user in the dashboard.
	 */
	long SYSTEM_USER_ID = 1;
	
	/**
	 * Value representing ascending order of sort.
	 */
	String SORT_ASC = "asc";
	
	/**
	 * Value representing descending order of sort.
	 */
	String SORT_DESC = "desc";

	/**
	 * Maximum length of varchar data type in MySQL.
	 */
	int MYSQL_MAX_VARCHAR_LENGTH = 16_000;

	/**
	 * Format of date sent in email.
	 */
	String EMAIL_DATE_PATTERN = "dd/MM/yyyy";
	
	/**
	 * Value representing max length of folder name allowed in dam.
	 */
	int DAM_MAX_CHAR = 118;
	
	/**
	 * Value representing delimiter for step for dam folder name.
	 */
	String STEP_DELIMITER = "#@@#";
	
	/**
	 * Value representing delimiter for workflow for dam folder name.
	 */
	String WORKFLOW_DELIMITER = "_";

}
