package com.example.demo.converter;


import com.example.demo.dto.Gender;
import com.example.demo.dto.UserDto;
import com.example.demo.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", imports = {Gender.class})
public interface UserConverter {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "password", target = "passwd")
    @Mapping(target = "gender", expression = "java( Gender.build(user.getGender()) )")
    UserDto toUserDto(User user);
}
