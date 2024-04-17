package com.naehas.genie.constant.service.offer;

import com.naehas.genie.dto.request.offer.OfferRequestDTO;
import com.naehas.genie.dto.response.offer.OfferResponseDTO;
import com.naehas.genie.exception.InvalidInputException;

public interface OfferService {

    /**
     * Creates and saves a new offer in the database.
     *
     * @param 	offerRequestDto
     * 			new offer request.
     *
     * @return 	Created offer.
     *
     * @throws	InvalidInputException
     * 			<li>
     * 				If an offer with the offer code already exists
     * 			</li>
     */
    OfferResponseDTO createOffer(OfferRequestDTO offerRequestDto) throws InvalidInputException;

}
