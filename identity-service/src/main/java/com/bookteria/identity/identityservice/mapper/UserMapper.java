package com.bookteria.identity.identityservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.bookteria.identity.identityservice.dto.request.UserCreationRequest;
import com.bookteria.identity.identityservice.dto.request.UserUpdateRequest;
import com.bookteria.identity.identityservice.dto.response.UserResponse;
import com.bookteria.identity.identityservice.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);

    UserResponse toUserResponse(User user);

    @Mapping(target = "roles", ignore = true)
    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}
