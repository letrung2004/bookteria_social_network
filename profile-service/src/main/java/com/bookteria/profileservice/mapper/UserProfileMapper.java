package com.bookteria.profileservice.mapper;

import org.mapstruct.Mapper;

import com.bookteria.profileservice.dto.request.ProfileCreationRequest;
import com.bookteria.profileservice.dto.response.UserProfileResponse;
import com.bookteria.profileservice.entity.UserProfile;

@Mapper(componentModel = "spring")
public interface UserProfileMapper {
    UserProfile toUserProfile(ProfileCreationRequest request);

    UserProfileResponse toUserProfileResponse(UserProfile entity);
}
