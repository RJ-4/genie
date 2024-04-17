package com.naehas.genie.controller;

import com.naehas.genie.dto.request.OfferRequestDTO;
import com.naehas.genie.dto.response.OfferResponseDTO;
import com.naehas.genie.service.OfferService;

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
 * REST controller for operations relating to offers.
 *
 * <p>
 * All the RESTful web services end-points pertaining to offers are created and defined here.
 * </p>
 *
 * @author Piyush Kapoor
 * @see com.naehas.genie.entity.Offer
 * @since 15 April 2024
 */
@RestController
@RequestMapping("/v1/offers")
@Slf4j
@Tag(name = "OfferController", description = "REST APIs related to offers!!!")
public class OfferController {

    @Autowired
    private OfferService offerService;

    /**
     * REST API endpoint for creating a new offer   .
     *
     * @param offerRequestDTO DTO object received from API request with step template input configurations.
     * @return Created step template with configurations.
     */
    @PostMapping(value = "",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(summary = "Create a new step template")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Created"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public ResponseEntity<OfferResponseDTO> createStepTemplate(@Valid
                                                                  @RequestBody
                                                                  @Parameter(name = "newOfferRequestDTO",
                                                                          description = "List of properties to create a new step template")
                                                                  OfferRequestDTO offerRequestDTO) {

        log.info("Request received to create a new step template with name: " + offerRequestDTO.getCode());

        OfferResponseDTO stepTemplateResponseDto = offerService.createOffer(offerRequestDTO);

        log.info("Request received to create a new step template with name: " + offerRequestDTO.getCode() + " processed successfully");

        return new ResponseEntity<>(stepTemplateResponseDto, HttpStatus.CREATED);
    }

}
