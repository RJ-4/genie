package com.naehas.genie.controller;

import com.naehas.genie.dto.request.OfferTypeRequestDTO;
import com.naehas.genie.dto.response.NewOfferTypeResponseDTO;
import com.naehas.genie.service.OfferTypeService;

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
 * @see com.naehas.genie.entity.OfferType
 * @since 15 April 2024
 */
@RestController
@RequestMapping("/v1/offer-types")
@Slf4j
@Tag(name = "Offer Type Controller", description = "REST APIs related to offer types!!!")
public class OfferTypeController {

    @Autowired
    private OfferTypeService offerTypeService;

    /**
     * REST API endpoint for creating a new offer type.
     *
     * @param offerTypeRequestDTO DTO object received from API request with offer type input configurations.
     * @return Created offer type with configurations.
     */
    @PostMapping(value = "",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(summary = "Create a new offer type")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Created"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public ResponseEntity<NewOfferTypeResponseDTO> createOfferType(@Valid
                                                                   @RequestBody
                                                                   @Parameter(name = "newOfferTypeRequestDTO",
                                                                           description = "List of properties to create a new step template")
                                                                   OfferTypeRequestDTO offerTypeRequestDTO) {

        log.info("Request received to create a new offer type with name: " + offerTypeRequestDTO.getName());

        NewOfferTypeResponseDTO newOfferTypeResponseDTO = offerTypeService.createOfferType(offerTypeRequestDTO);

        log.info("Request received to create a new step template with name: " + offerTypeRequestDTO.getName() + " processed successfully");

        return new ResponseEntity<>(newOfferTypeResponseDTO, HttpStatus.CREATED);
    }
}
