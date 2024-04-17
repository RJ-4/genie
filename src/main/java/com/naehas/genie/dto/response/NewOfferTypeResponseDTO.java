package com.naehas.genie.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.naehas.genie.dto.response.common.BaseResponseDTO;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.*;

/**
 * API response DTO/model when a new step template is created.
 *
 * <p>
 * This class describes all the properties (both required or optional) that were used to create a new step template.
 * </p>
 *
 * @author Piyush Kapoor
 * @see        com.naehas.genie.entity.OfferType
 * @see        BaseResponseDTO
 * @since 15 April 2024
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonInclude(Include.NON_NULL)
@Tag(name = "NewOfferTypeResponseDTO", description = "List of properties of a created offer type")
public class NewOfferTypeResponseDTO extends BaseResponseDTO {

    private static final long serialVersionUID = 1046732062677583202L;

    @Schema(name = "name" ,description = "Name of the offer type. Has to be unique across database",
            example = "Creative Updates")
    private String name;

    @Schema(name = "active" , description = "Default name of the step instance that will be initialized from this step template",
            example = "Creative Updates")
    private boolean active;


}
