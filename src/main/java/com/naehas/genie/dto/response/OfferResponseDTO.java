package com.naehas.genie.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.naehas.genie.dto.response.common.BaseResponseDTO;
import com.naehas.genie.entity.OfferType;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.*;

/**
 * API response DTO/model when a new offer is created.
 *
 * <p>
 * This class describes all the properties (both required or optional) that were used to create a new offer.
 * </p>
 *
 * @author Piyush Kapoor
 * @see com.naehas.genie.entity.Offer
 * @see BaseResponseDTO
 * @since 15 April 2024
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonInclude(Include.NON_NULL)
@Tag(name = "OfferResponseDTO", description = "List of properties of a created offer")
public class OfferResponseDTO extends BaseResponseDTO {

    private static final long serialVersionUID = 5815438631812536925L;

    @Schema(name = "code", description = "Code of the offer. Has to be unique across database", example = "Creative Updates")
    private String code;

    @Schema(name = "status", description = "Status of the offer", example = "New")
    private String status;

    @Schema(name = "offerType", description = "Type of offer that is going to be created", example = "Disclosures")
    private OfferType offerType;

}
