package com.bookteria.identity.identityservice.mapper;

import com.bookteria.identity.identityservice.dto.request.ProfileCreationRequest;
import com.bookteria.identity.identityservice.dto.request.UserCreationRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfileMapper {
    ProfileCreationRequest toProfileCreationRequest(UserCreationRequest request);
}
