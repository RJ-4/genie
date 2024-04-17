package com.naehas.genie.service;

import com.naehas.genie.dto.request.OfferTypeRequestDTO;
import com.naehas.genie.dto.response.NewOfferTypeResponseDTO;
import com.naehas.genie.entity.OfferType;
import com.naehas.genie.exception.InvalidInputException;

public interface OfferTypeService {

    /**
     * Creates and saves a new offer type in the database.
     *
     * @param 	offerTypeRequestDto
     * 			new offer type request.
     *
     * @return 	Created offer type.
     *
     * @throws	InvalidInputException
     * 			<li>
     * 				If an offer type with the name already exists
     * 			</li>
     */
    NewOfferTypeResponseDTO createOfferType(OfferTypeRequestDTO offerTypeRequestDto) throws InvalidInputException;
    
    /**
     * 
     * @param id
     * @return
     * @throws InvalidInputException
     */
    OfferType getOfferType(Long id) throws InvalidInputException;
}
