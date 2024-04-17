package com.naehas.genie.dto.request.offer;

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
 * API request DTO/model representing properties required to add or remove an offer
 *
 * <p>
 * This class describes all the properties required to add or remove an offer
 * </p>
 *
 * @author Piyush Kapoor
 * @see com.naehas.genie.entity.Offer
 * @since 15 April 2024
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Tag(name = "OfferRequestDTO", description = "Properties describing offer information")
public class OfferRequestDTO implements Serializable {

    private static final long serialVersionUID = -3119767856538893351L;

    @NotBlank(message = "Offer code is required")
    @Size(max = ApplicationConstants.MYSQL_MAX_VARCHAR_LENGTH,
            message = "Number of characters cannot be more than" + ApplicationConstants.MYSQL_MAX_VARCHAR_LENGTH)
    @Pattern(regexp = "^[^/?,<>\\:*|\"^]*", message = "Following characters: /?,<>\\:*|\"^ are not allowed")
    @Schema(name = "code" , description = "Code of the offer that will be initialized", example = "New")
    private String code;

    @NotBlank(message = "Status is required")
    @Pattern(regexp = "^[^/?,<>\\:*|\"^]*", message = "Following characters: /?,<>\\:*|\"^ are not allowed")
    @Schema(name = "status" ,description = "Default status of the offer that will be initialized", example = "New")
    private String status;

    @NotNull(message = "Offer Type from which a new offer instance is to be created is required")
    @Schema(name = "offerTypeId", description = "Id of the offer type from which a new offer instance is to be created", example = "4")
    private Long offerTypeId;

    @NotNull(message = "Application User who is going to create the offer")
    @Schema(name = "userId", description = "Id of the user who is going to create the offer", example = "12")
    private Long userId;
}

