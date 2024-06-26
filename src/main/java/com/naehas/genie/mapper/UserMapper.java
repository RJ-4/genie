package com.naehas.genie.mapper;

import com.naehas.genie.dto.request.UserRequestDTO;
import com.naehas.genie.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 *
 * <p>
 * 	Custom mapper for copying data among different user DTOs implemented using {@code MapStruct}.
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
public interface UserMapper {
	
	/**
	 * Instance of {@code UserMapper} using which methods of this interface can be accessed in other mappers.
	 */
	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	

	User mapToUser(UserRequestDTO userRequestDto);

	default User mapToUser(UserRequestDTO userRequestDto,
						   Long createdBy) {

		User user = this.mapToUser(userRequestDto);
		user.setCreatedBy(createdBy);
		user.setUpdatedBy(createdBy);

		return user;
	}
}
