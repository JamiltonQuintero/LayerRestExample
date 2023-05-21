package com.jamiltonquintero.layer.business.mapper;

import com.jamiltonquintero.layer.domain.dto.request.UserRequest;
import com.jamiltonquintero.layer.domain.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring") 
public interface UserRequestMapper {


    @Mapping(source = "name", target = "name")
    @Mapping(source = "age", target = "age")
    @Mapping(source = "country", target = "country")
    User toDomain(UserRequest request);
}
