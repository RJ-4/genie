package com.naehas.genie.dto.request;

import com.naehas.genie.constant.ApplicationConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import lombok.*;

/**
 * API request DTO/model representing properties required to add or remove an offer type
 *
 * <p>
 * This class describes all the properties required to add or remove an offer type
 * </p>
 *
 * @author Piyush Kapoor
 * @see com.naehas.genie.entity.OfferType
 * @since 15 April 2024
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Tag(name = "OfferTypeRequestDTO", description = "Properties describing offer type information")
public class OfferTypeRequestDTO implements Serializable {

    private static final long serialVersionUID = -8236316321441520338L;

    @NotBlank(message = "Offer code is required")
    @Size(max = ApplicationConstants.MYSQL_MAX_VARCHAR_LENGTH,
            message = "Number of characters cannot be more than" + ApplicationConstants.MYSQL_MAX_VARCHAR_LENGTH)
    @Pattern(regexp = "^[^/?,<>\\:*|\"^]*", message = "Following characters: /?,<>\\:*|\"^ are not allowed")
    @Schema(name= "name" , description = "Offer code has to be unique across database", example = "Creative Updates")
    private String name;

    @Schema(name= "active" , description = "Default status of the offer that will be initialized", example = "New")
    private boolean active;

    @NotNull(message = "Application User who is going to create the offer")
    @Schema(name= "userId" , description = "Id of the user who is going to create the offer", example = "12")
    private Long userId;
}

