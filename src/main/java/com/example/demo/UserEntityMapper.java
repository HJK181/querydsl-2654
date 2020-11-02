package com.example.demo;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserEntityMapper {

	UserEntity toTenantEntity(UserDTO dto);

	UserDTO fromTenantEntity(UserEntity entity);
}
