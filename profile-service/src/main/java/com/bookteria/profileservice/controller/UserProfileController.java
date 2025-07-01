package com.bookteria.profileservice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.bookteria.profileservice.dto.ApiResponse;
import com.bookteria.profileservice.dto.response.UserProfileResponse;
import com.bookteria.profileservice.service.UserProfileService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserProfileController {
    UserProfileService userProfileService;

    @GetMapping("/users/{profileId}")
    ApiResponse<UserProfileResponse> getProfile(@PathVariable String profileId) {
        return ApiResponse.<UserProfileResponse>builder()
                .result(userProfileService.getUserProfileById(profileId))
                .build();
    }

    @GetMapping("/users")
    ApiResponse<List<UserProfileResponse>> getAllProfiles() {
        return ApiResponse.<List<UserProfileResponse>>builder()
                .result(userProfileService.getAllUserProfiles())
                .build();
    }
}
