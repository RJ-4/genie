package com.naehas.genie.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

@Entity
@Table(name = "n_offer_types")
@Audited(withModifiedFlag = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OfferType extends BaseEntity{
    /**
     * Name of the offer type.
     *
     * <p>
     * Cannot be null or empty.
     * </p>
     */
    @Pattern(regexp = "^[^/?,<>\\:*|\"^]*",
            message = "Following characters: /?,<>\\:*|\"^ are not allowed")
    @Column(nullable = false)
    private String name;

    /**
     * Whether offer type is enabled?.
     *
     * <p>
     * Cannot be null or empty.
     * </p>
     */
    @Column(name = "is_active")
    private boolean active = false;


}
