package com.example.vetclinic.application.mapper;

import com.example.vetclinic.application.dto.UserDTO;
import com.example.vetclinic.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "roles", expression = "java(user.getRoles().stream().map(r -> r.getName()).collect(java.util.stream.Collectors.toSet()))")
    UserDTO toDto(User user);
}
