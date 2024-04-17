package com.naehas.genie.dto.response.file;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.naehas.genie.dto.response.BaseResponseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.*;

/**
 * API response DTO/model when a new file is created.
 *
 * <p>
 * This class describes all the properties (both required or optional) that were used to create a new file.
 * </p>
 *
 * @author Piyush Kapoor
 * @see com.naehas.genie.entity.File
 * @see BaseResponseDTO
 * @since 15 April 2024
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonInclude(Include.NON_NULL)
@Tag(name = "FileResponseDTO", description = "List of properties of a created file")
public class FileResponseDTO extends BaseResponseDTO {

    private static final long serialVersionUID = 5815438631812536925L;

    @Schema(name = "name", description = "Name of the file", example = "Disclosure.pdf")
    private String name;

    @Schema(name = "type", description = "Type of the file that is going to be created", example = "HTML_FILE")
    private String type;

    @Schema(name = "subdirectory", description = "Location where file will be saved", example = "nDrive/Creative Updates")
    private String subdirectory;

    @Schema(name = "parentFileId", description = "Folder where file be saved", example = "nDrive/EnterPrise Disclosures")
    private Long parentFileId;

}
