package com.naehas.genie.service.impl;

import com.naehas.genie.constant.ErrorMessageConstants;
import com.naehas.genie.dto.request.OfferTypeRequestDTO;
import com.naehas.genie.dto.response.NewOfferTypeResponseDTO;
import com.naehas.genie.entity.OfferType;
import com.naehas.genie.exception.InvalidInputException;
import com.naehas.genie.mapper.OfferTypeMapper;
import com.naehas.genie.repository.OfferTypeRepository;
import com.naehas.genie.service.OfferTypeService;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
@Slf4j
public class OfferTypeServiceImpl implements OfferTypeService {

    @Autowired
    private OfferTypeRepository offerTypeRepository;

    @Autowired
    private OfferTypeMapper offerTypeMapper;

    @Override
    public NewOfferTypeResponseDTO createOfferType(OfferTypeRequestDTO offerTypeRequestDto)
            throws InvalidInputException {
    	
        Long userId = offerTypeRequestDto.getUserId();

        String name = offerTypeRequestDto.getName();
        this.validateDuplicateName(name);

        log.info("Creating an offer type with name: " + name);

        OfferType offerType = offerTypeMapper.mapToOfferType(offerTypeRequestDto, userId);

        offerType = offerTypeRepository.save(offerType);

        log.info("Offer with code: " + name + " created successfully with id: " + offerType.getId());

        NewOfferTypeResponseDTO newOfferTypeResponseDTO = offerTypeMapper.mapToNewOfferTypeResponseDTO(offerType);

        return newOfferTypeResponseDTO;

    }
    
    /**
     * 
     * @param id
     * @return
     * @throws InvalidInputException
     */
    @Override
	public OfferType getOfferType(Long id) throws InvalidInputException {
		
    	log.info("Retrieving offer type with id: {}", id);
    	
    	String errorMessge = "Offer type with id: " + id + " does not exist";
    	
    	OfferType offerType = offerTypeRepository.findById(id)
    											 .orElseThrow(() -> new InvalidInputException(String.format(ErrorMessageConstants.ERROR_OFFER_TYPE_ID_NOT_EXISTS, "" + id), errorMessge));
    	
    	log.info("Successfully retrieved offer type with id: {}", id);
    	
    	return offerType;
	}

    
    /**
     * Validates whether an offer type with a name already exists or not.
     *
     * <p>
     * If an offer type with the input parameter {@code name} already exists,
     * then an {@code InvalidInputException} is thrown.
     * </p>
     *
     * @param name Name of a new offer type input by the user
     * @throws InvalidInputException If an offer type with the input parameter {@code name} already exists.
     */
    private void validateDuplicateName(String name) throws InvalidInputException {

        log.info("Validating whether an offer type with name: " + name + " already exists");

        boolean offerTypeExists = offerTypeRepository.existsByNameAndActive(name, true);

        if (offerTypeExists) {
            String errorMessage = "Offer type with name: " + name + " already exists";
            throw new InvalidInputException(ErrorMessageConstants.ERROR_OFFER_ALREADY_EXISTS, errorMessage);
        }

        log.info("Offer type with name: " + name + " does not exist");
    }

}
