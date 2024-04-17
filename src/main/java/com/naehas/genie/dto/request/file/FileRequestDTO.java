package com.naehas.genie.dto.request.file;

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
 * API request DTO/model representing properties required to add or remove a file
 *
 * <p>
 * This class describes all the properties required to add or remove a file
 * </p>
 *
 * @author Piyush Kapoor
 * @see com.naehas.genie.entity.File
 * @since 15 April 2024
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Tag(name = "FileRequestDTO", description = "Properties describing file information")
public class FileRequestDTO implements Serializable {

    private static final long serialVersionUID = -3119767856538893351L;

    @NotBlank(message = "File name is required")
    @Size(max = ApplicationConstants.MYSQL_MAX_VARCHAR_LENGTH,
            message = "Number of characters cannot be more than" + ApplicationConstants.MYSQL_MAX_VARCHAR_LENGTH)
    @Pattern(regexp = "^[^/?,<>\\:*|\"^]*", message = "Following characters: /?,<>\\:*|\"^ are not allowed")
    @Schema(name = "name", description = "Name of the file that will be created", example = "Disclosure.html")
    private String name;

    @NotBlank(message = "Subdirectory is required")
    @Pattern(regexp = "^[^?,<>\\:*|\"^]*", message = "Following characters: /?,<>\\:*|\"^ are not allowed")
    @Schema(name = "subdirectory", description = "Location where the file will be saved", example = "nDrive/Workflows")
    private String subdirectory;

    @NotBlank(message = "File type is required")
    @Pattern(regexp = "^[^/?,<>\\:*|\"^]*", message = "Following characters: /?,<>\\:*|\"^ are not allowed")
    @Schema(name = "type", description = "Type of the file", example = "HTML_FILE")
    private String type;

    @NotNull(message = "Folder id is required")
    @Schema(name = "parentFileId", description = "Id of the folder", example = "4")
    private Long parentFileId;

    @NotNull(message = "Application User who is going to create the offer")
    @Schema(name = "userId", description = "Id of the user who is going to create the offer", example = "12")
    private Long userId;
}

