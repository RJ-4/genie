package com.naehas.genie.controller;

import com.naehas.genie.constant.service.file.FileService;
import com.naehas.genie.dto.request.file.FileRequestDTO;
import com.naehas.genie.dto.response.file.FileResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for operations relating to files.
 *
 * <p>
 * All the RESTful web services end-points pertaining to files are created and defined here.
 * </p>
 *
 * @author Piyush Kapoor
 * @see com.naehas.genie.entity.File
 * @since 15 April 2024
 */
@RestController
@RequestMapping("/v1/files")
@Slf4j
@Tag(name = "FileController", description = "REST APIs related to files!!!")
public class FileController {

    @Autowired
    private FileService fileService;

    /**
     * REST API endpoint for creating a new file.
     *
     * @param fileRequestDTO DTO object received from API request with step template input configurations.
     * @return Created step template with configurations.
     */
    @PostMapping(value = "",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(summary = "Create a new file")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Created"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public ResponseEntity<FileResponseDTO> createFile(@Valid
                                                         @RequestBody
                                                         @Parameter(name = "fileRequestDTO",
                                                                 description = "List of properties to create a new file")
                                                         FileRequestDTO fileRequestDTO) {

        log.info("Request received to create a new file with name: " + fileRequestDTO.getName());

        FileResponseDTO fileResponseDto = fileService.createFile(fileRequestDTO);

        log.info("Request received to create a new file with name: " + fileResponseDto.getName() + " processed successfully");

        return new ResponseEntity<>(fileResponseDto, HttpStatus.CREATED);
    }

}
