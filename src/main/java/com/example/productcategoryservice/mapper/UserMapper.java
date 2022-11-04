package com.example.productcategoryservice.mapper;

import com.example.productcategoryservice.dto.CreatUserDto;
import com.example.productcategoryservice.dto.UserDto;
import com.example.productcategoryservice.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface UserMapper {

//    @Mapping(target = "role", defaultValue = "USER")
    User map(CreatUserDto createUserDto);
    UserDto map(User user);
}
