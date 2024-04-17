package com.naehas.genie.dto.response.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Base class defining common properties that will be sent as part of API response for all/most APIs where pagination is required.
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
@ToString
@JsonInclude(Include.NON_NULL)
@Tag(name = "BasePaginationResponseDTO", description = "Common properties that are returned as part of API response for almost all paginated requests.")
public class BasePaginationResponseDTO implements Serializable {

    private static final long serialVersionUID = 4533859268418874907L;

    @Schema(name = "totalItems", description = "Total number of items", example = "1000")
    protected Long totalItems;

    @Schema(name = "totalPages", description = "Total number of pages", example = "10")
    protected int totalPages;

    @Schema(name = "currentPage", description = "Current page", example = "0")
    protected int currentPage;
}
