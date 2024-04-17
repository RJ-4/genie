package com.naehas.genie.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.RevisionEntity;

/**
 * Entity class for audit revisions created by Envers.
 * 
 * <p>
 * 	Extends {@link DefaultRevisionEntity DefaultRevisionEntity}.
 * </p>
 * 
 * <p>
 * 	This class overrides the default table {@code revinfo} created by Envers and creates a custom implementation 
 * 	allowing us to store additional properties.
 * </p>
 * 
 * <p>
 * 	This table will contain columns created by Envers by default.
 *  In order to add additional columns to this revisions table, declare the columns as fields using {@code @Column} annotation
 *  similar to how columns are described in other entities.	
 * </p>
 * 
 * @author 	Rishabh Jain
 * @see		com.naehas.genie.entity.AuditRevisionHistory
 * @see		DefaultRevisionEntity
 * @since	30th June 2022
 * 
 */
@Entity
@Table(name = "revision_info")
@RevisionEntity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Getter
@Setter
public class AuditRevisionHistory extends DefaultRevisionEntity {

	private static final long serialVersionUID = -1920214750170757377L;

}
