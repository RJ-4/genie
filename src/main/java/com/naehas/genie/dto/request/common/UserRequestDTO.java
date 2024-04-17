package com.naehas.genie.dto.request.common;

import com.naehas.genie.constant.ApplicationConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import lombok.*;

/**
 * API request DTO/model representing properties required to add or remove a delegate for a user in workflow and step instances.
 *
 * <p>
 * This class describes all the properties required to add or remove a delegate for a user in workflow and step instances.
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
@Tag(name = "UserRequestDTO", description = "Properties describing user information")
public class UserRequestDTO implements Serializable {

    private static final long serialVersionUID = -760869534945024079L;

    @NotBlank(message = "Name is required")
    @Size(max = ApplicationConstants.MYSQL_MAX_VARCHAR_LENGTH,
            message = "Number of characters cannot be more than" + ApplicationConstants.MYSQL_MAX_VARCHAR_LENGTH)
    @Pattern(regexp = "^[^/?,<>\\:*|\"^]*", message = "Following characters: /?,<>\\:*|\"^ are not allowed")
    @Schema(name = "userName" , description = "Name of the step template. Has to be unique across database",
            example = "Creative Updates")
    private String userName;

    @NotBlank(message = "Default Title is required")
    @Pattern(regexp = "^[^/?,<>\\:*|\"^]*", message = "Following characters: /?,<>\\:*|\"^ are not allowed")
    @Schema(name = "email" , description = "Default name of the step instance that will be initialized from this step template",
            example = "Creative Updates")
    private String email;
}

