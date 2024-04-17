package com.naehas.genie.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naehas.genie.constant.ErrorMessageConstants;
import com.naehas.genie.dto.request.OfferRequestDTO;
import com.naehas.genie.dto.response.OfferResponseDTO;
import com.naehas.genie.entity.Offer;
import com.naehas.genie.entity.OfferType;
import com.naehas.genie.exception.InvalidInputException;
import com.naehas.genie.mapper.OfferMapper;
import com.naehas.genie.repository.OfferRepository;
import com.naehas.genie.service.OfferService;
import com.naehas.genie.service.OfferTypeService;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class OfferServiceImpl implements OfferService {

    @Autowired
    private OfferRepository offerRepository;

    @Autowired
    private OfferMapper offerMapper;
    
    @Autowired
    private OfferTypeService offerTypeService;

    @Override
    public OfferResponseDTO createOffer(OfferRequestDTO offerRequestDto) throws InvalidInputException {
        
    	Long userId = offerRequestDto.getUserId();

        String offerCode = offerRequestDto.getCode();
        this.validateDuplicateCode(offerCode);

        log.info("Creating an offer with code: {}", offerCode);
        
        OfferType offerType = offerTypeService.getOfferType(offerRequestDto.getOfferTypeId());
        
        Offer offer = offerMapper.mapToOffer(offerRequestDto, offerType, userId);

        offer = offerRepository.save(offer);

        log.info("Offer with code: " + offerCode + " created successfully with id: " + offer.getId());

        OfferResponseDTO offerResponseDTO = offerMapper.mapToNewOfferResponseDTO(offer);

        return offerResponseDTO;


    }

    /**
     * Validates whether an offer with a code already exists or not.
     *
     * <p>
     * If an offer with the input parameter {@code code} already exists,
     * then an {@code InvalidInputException} is thrown.
     * </p>
     *
     * @param code Code of a new offer input by the user
     * @throws InvalidInputException If a new offer with the input parameter {@code code} already exists.
     */
    private void validateDuplicateCode(String code) throws InvalidInputException {

        log.info("Validating whether an offer with code: " + code + " already exists");

        boolean offerExists = offerRepository.existsByCodeAndActive(code, true);

        if (offerExists) {
            String errorMessage = "Offer with code: " + code + " already exists";
            throw new InvalidInputException(ErrorMessageConstants.ERROR_OFFER_ALREADY_EXISTS, errorMessage);
        }

        log.info("Offer with code: " + code + " does not exist");
    }
}
