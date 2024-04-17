package com.naehas.genie.dto.response.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.naehas.genie.dto.response.BaseResponseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Class defining standard properties(id & name) while setting up user information.
 *
 * <p>
 * Any {@code ResponseDTO} class just needs to extend this class to add the defined property as part of that API response.
 * </p>
 *
 * @author Piyush kapoor
 * @since 15 April 2024
 */
@Getter
@Setter
@ToString
@JsonInclude(Include.NON_NULL)
@Tag(name = "UserResponseDTO", description = "Standard properties that are returned as part of different API responses around user info.")
public class UserResponseDTO extends BaseResponseDTO {

    private static final long serialVersionUID = -7453168958691188120L;

    @Schema(name = "id", description = "Id of the user", example = "1000")
    private Long id;

    @Schema(name = "userName", description = "Display username of the user", example = "User")
    private String userName;

    @Schema(name = "email", description = "Display email of the user", example = "test@gmail.com")
    private String email;


}
