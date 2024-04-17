package com.naehas.genie.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.*;

/**
 * Base class defining common properties that will be sent as part of API response for all/most APIs
 * where both pagination and sorting are required.
 *
 * <p>
 * Any {@code ResponseDTO} class just needs to extend this class to add the defined property as part of that API response.
 * </p>
 *
 * @author Piyush Kapoor
 * @see com.naehas.genie.dto.response.BasePaginationResponseDTO
 * @since 15 April 2024
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
@ToString
@Tag(name = "BasePaginationAndSortResponseDTO", description = "Common properties that are returned as part of API response for almost all pagination and sort requests.")
public class BasePaginationAndSortResponseDTO extends BasePaginationResponseDTO {

    private static final long serialVersionUID = -1262017517509017030L;

    @Schema(name = "sortBy", description = "Name of the property for which data is sorted", example = "name")
    protected String sortBy;

    @Schema(name = "orderBy", description = "Order in which data is sorted", allowableValues = "asc,desc")
    protected String orderBy;
}
