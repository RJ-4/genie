package com.naehas.genie.mapper.offertype;

import com.naehas.genie.dto.request.offertype.OfferTypeRequestDTO;
import com.naehas.genie.dto.response.offertype.NewOfferTypeResponseDTO;
import com.naehas.genie.entity.OfferType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * 
 * <p>
 * 	Custom mapper for copying data among different offer types DTOs implemented using {@code MapStruct}.
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
public interface OfferTypeMapper {
	
	/**
	 * Instance of {@code UserMapper} using which methods of this interface can be accessed in other mappers.
	 */
	OfferTypeMapper INSTANCE = Mappers.getMapper(OfferTypeMapper.class);
	

	OfferType mapToOfferType(OfferTypeRequestDTO offerTypeRequestDTO);

	default OfferType mapToOfferType(OfferTypeRequestDTO offerTypeRequestDTO,
                                     Long createdBy) {

		OfferType offerType = this.mapToOfferType(offerTypeRequestDTO);
		offerType.setCreatedBy(createdBy);
		offerType.setUpdatedBy(createdBy);

		return offerType;
	}

	@Mappings({
			@Mapping(source = "createdBy", target = "createdBy.id")
	})
	NewOfferTypeResponseDTO mapToNewOfferTypeResponseDto(OfferType offerType);

	/**
	 * Maps properties/fields from
	 * {@link com.naehas.genie.entity.OfferType OfferType}
	 * 		to
	 * {@link com.naehas.genie.dto.response.offertype.NewOfferTypeResponseDTO NewOfferTypeResponseDTO}.
	 *
	 * @param 	offerType
	 * 			Source {@code OfferType} object from which properties will be copied.
	 *
	 * @return	{@code NewOfferTypeResponseDTO} object with initialized properties.
	 */
	default NewOfferTypeResponseDTO mapToNewOfferTypeResponseDTO(OfferType offerType) {

		NewOfferTypeResponseDTO newOfferTypeResponseDTO = this.mapToNewOfferTypeResponseDto(offerType);

		return newOfferTypeResponseDTO;
	}
}