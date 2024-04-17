package com.naehas.genie.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.envers.Audited;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Class which contains common fields to be used across other entities.
 *
 * <p>
 * Other entities which require columns mentioned below (as fields) can simply extend this class without having to re-write these fields as columns
 * in their own implementation.
 * </p>
 * 
 * <p>
 * There is no table for this class in the database, since it's only purpose is to provide common functionality across other entities 
 * and not have it's own identity. 
 * </p>
 * 
 * @author 	Rishabh Jain
 * @since	29th September 2021
 *
 */
@MappedSuperclass
@Audited(withModifiedFlag = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BaseEntity {

	/**
	 * Id of the record.
	 * 
	 * <p>
	 * The next value is calculated by incrementing the previous id by 1.
	 * </p>
	 */
	@Id
	@Column
	protected Long id;
	
	/**
	 * User id of the user who created this record.
	 * 
	 * <p>
	 * Cannot be null.
	 * </p>
	 */
	@Column(name = "created_by", nullable = false)
	protected Long createdBy;
	
	/**
	 * User id of the user who last updated this record.
	 * 
	 * <p>
	 * Cannot be null.
	 * </p>
	 */
	@Column(name = "updated_by", nullable = false)
	protected Long updatedBy;
	
	/**
	 * Date and time of the time of creation of this record in UTC.
	 * 
	 * <p>
	 * Cannot be null.
	 * </p>
	 * 
	 * Note: In order to change the time zone, update the value of "spring.jpa.properties.hibernate.jdbc.time_zone" in application.properties. 
	 */
	@Column(name = "created_on", nullable = false)
	@CreationTimestamp
	protected LocalDateTime createdOn;
	
	/**
	 * Date and time when this record was last updated in UTC.
	 * 
	 * <p>
	 * Cannot be null.
	 * </p>
	 * 
	 * Note: In order to change the time zone, update the value of "spring.jpa.properties.hibernate.jdbc.time_zone" in application.properties.
	 */
	@Column(name = "updated_on", nullable = false)
	@UpdateTimestamp
	protected LocalDateTime updatedOn;
}
