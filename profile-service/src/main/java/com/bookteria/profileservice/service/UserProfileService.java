package com.bookteria.profileservice.service;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.bookteria.profileservice.dto.request.ProfileCreationRequest;
import com.bookteria.profileservice.dto.response.UserProfileResponse;
import com.bookteria.profileservice.entity.UserProfile;
import com.bookteria.profileservice.mapper.UserProfileMapper;
import com.bookteria.profileservice.repository.UserProfileRepository;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class UserProfileService {
    UserProfileRepository userProfileRepository;
    UserProfileMapper userProfileMapper;

    public UserProfileResponse createProfile(ProfileCreationRequest request) {
        UserProfile userProfile = userProfileMapper.toUserProfile(request);
        userProfileRepository.save(userProfile);
        return userProfileMapper.toUserProfileResponse(userProfile);
    }

    public UserProfileResponse getUserProfileById(String id) {
        UserProfile userProfile =
                userProfileRepository.findById(id).orElseThrow(() -> new RuntimeException("UserProfile not found"));
        return userProfileMapper.toUserProfileResponse(userProfile);
    }

    @PreAuthorize("hasRole('ADMIN')")
    public List<UserProfileResponse> getAllUserProfiles() {
        var userProfiles = userProfileRepository.findAll();
        return userProfiles.stream()
                .map(userProfileMapper::toUserProfileResponse)
                .toList();
    }
}
