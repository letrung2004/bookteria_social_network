package com.bookteria.profileservice.mapper;

import com.bookteria.profileservice.dto.request.ProfileCreationRequest;
import com.bookteria.profileservice.dto.response.UserProfileResponse;
import com.bookteria.profileservice.entity.UserProfile;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserProfileMapper {
    UserProfile toUserProfile(ProfileCreationRequest request);
    UserProfileResponse toUserProfileResponse(UserProfile entity);
}
