package com.naehas.genie.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.naehas.genie.dto.response.common.UserResponseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.*;

/**
 * Base class defining common properties that will be sent as part of API response for all/most APIs.
 *
 * <p>
 * Any {@code ResponseDTO} class just needs to extend this class to add the defined property as part of that API response.
 * </p>
 *
 * @author Piyush Kapoor
 * @since 15 April 2024
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonInclude(Include.NON_NULL)
@Tag(name = "BaseResponseDTO", description = "Common properties that are returned as part of API response for almost all resources")
public class BaseResponseDTO implements Serializable {

    private static final long serialVersionUID = 1732007309083237122L;

    @Schema(name = "id", description = "Id of the resource",
            example = "1001")
    protected Long id;

    @Schema(name = "createdBy", description = "User id of the user who created this resource")
    protected UserResponseDTO createdBy;

    @Schema(name = "updatedBy", description = "User id of the user who last updated this resource", example = "101")
    protected Long updatedBy;

    @Schema(name = "createdOn", description = "Date and time (in UTC) when this resource was created", example = "2021-11-02T09:51:58.775000")
    protected LocalDateTime createdOn;

    @Schema(name = "updatedOn", description = "Date and time (in UTC) when this resource was last updated", example = "2021-11-02T09:51:58.775000")
    protected LocalDateTime updatedOn;
}
