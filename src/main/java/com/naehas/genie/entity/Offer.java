package com.naehas.genie.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

@Entity
@Table(name = "n_offers")
@Audited(withModifiedFlag = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Offer extends BaseEntity {
    /**
     * Code of the offer.
     *
     * <p>
     * Cannot be null or empty.
     * </p>
     */
    @Pattern(regexp = "^[^/?,<>\\:*|\"^]*",
            message = "Following characters: /?,<>\\:*|\"^ are not allowed")
    @Column(nullable = false, unique = true)
    private String code;

    /**
     * Status of the offer.
     *
     * <p>
     * Cannot be null or empty.
     * </p>
     */
    @Pattern(regexp = "^[^/?,<>\\:*|\"^]*",
            message = "Following characters: /?,<>\\:*|\"^ are not allowed")
    @Column(nullable = false)
    private String status;

    /**
     * Whether offer is enabled?.
     *
     * <p>
     * Cannot be null or empty.
     * </p>
     */
    @Column(name = "is_active")
    private boolean active = false;


    /**
     * Type of the offer.
     *
     * <p>
     * Cannot be null or empty.
     * </p>
     */
    @ManyToOne
    @JoinColumn(name = "offer_type_id", nullable = false)
    @JsonBackReference
    private OfferType offerType;


}
