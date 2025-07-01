package com.bookteria.identity.identityservice.mapper;

import org.mapstruct.Mapper;

import com.bookteria.identity.identityservice.dto.request.ProfileCreationRequest;
import com.bookteria.identity.identityservice.dto.request.UserCreationRequest;

@Mapper(componentModel = "spring")
public interface ProfileMapper {
    ProfileCreationRequest toProfileCreationRequest(UserCreationRequest request);
}
