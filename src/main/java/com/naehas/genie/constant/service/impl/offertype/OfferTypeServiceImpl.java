package com.naehas.genie.constant.service.impl.offertype;

import com.naehas.genie.constant.ErrorMessageConstants;
import com.naehas.genie.dto.request.offertype.OfferTypeRequestDTO;
import com.naehas.genie.dto.response.offertype.NewOfferTypeResponseDTO;
import com.naehas.genie.entity.OfferType;
import com.naehas.genie.exception.InvalidInputException;
import com.naehas.genie.mapper.offertype.OfferTypeMapper;
import com.naehas.genie.repository.offertype.OfferTypeRepository;
import com.naehas.genie.constant.service.offertype.OfferTypeService;
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
