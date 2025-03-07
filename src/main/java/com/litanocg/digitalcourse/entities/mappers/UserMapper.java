package com.litanocg.digitalcourse.entities.mappers;

import com.litanocg.digitalcourse.entities.User;
import com.litanocg.digitalcourse.entities.dtos.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "password", ignore = true)
    UserDTO toDTO(User user);

    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "updatedAt", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "userID", ignore = true)
    //@Mapping(target = "userDni", ignore = true)
    @Mapping(target = "passwordHash", source = "password")
    @Mapping(target = "statusRegistry", ignore = true)
    User toEntity(UserDTO userDTO);

    @Mapping(target = "createdAt", ignore = true) // No modificar createdAt
    void updateUserFromDTO(UserDTO userDTO, @MappingTarget User user);

}

