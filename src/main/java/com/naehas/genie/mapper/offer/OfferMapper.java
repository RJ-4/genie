package com.naehas.genie.mapper.offer;

import com.naehas.genie.dto.request.offer.OfferRequestDTO;
import com.naehas.genie.dto.response.offer.OfferResponseDTO;
import com.naehas.genie.entity.Offer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * <p>
 * 	Custom mapper for copying data among different offer DTOs implemented using {@code MapStruct}.
 * </p>
 * 
 * <p>
 * 	This is just an interface layer. 
 * 	Implementation class is automatically generated by {@code MapStruct} when build is created before starting the server.
 * </p>
 * 
 * @author 	Piyush Kapoor
 * @since	15 April 2024
 *
 */
@Mapper(componentModel = "spring")
public interface OfferMapper {
	
	/**
	 * Instance of {@code UserMapper} using which methods of this interface can be accessed in other mappers.
	 */
	OfferMapper INSTANCE = Mappers.getMapper(OfferMapper.class);
	

	Offer mapToOffer(OfferRequestDTO offerRequestDTO);

	default Offer mapToOffer(OfferRequestDTO offerRequestDTO,
							 Long createdBy) {

		Offer offer = this.mapToOffer(offerRequestDTO);
		offer.setCreatedBy(createdBy);
		offer.setUpdatedBy(createdBy);

		return offer;
	}

	@Mappings({
			@Mapping(source = "createdBy", target = "createdBy.id")
	})
	OfferResponseDTO mapToNewOfferResponseDto(Offer offer);

	/**
	 * Maps properties/fields from
	 * {@link com.naehas.genie.entity.Offer Offer}
	 * 		to
	 * {@link OfferResponseDTO NewOfferResponseDTO}.
	 *
	 * @param 	offer
	 * 			Source {@code Offer} object from which properties will be copied.
	 *
	 * @return	{@code NewOfferResponseDTO} object with initialized properties.
	 */
	default OfferResponseDTO mapToNewOfferResponseDTO(Offer offer) {

		OfferResponseDTO offerResponseDTO = this.mapToNewOfferResponseDto(offer);

		return offerResponseDTO;
	}
}