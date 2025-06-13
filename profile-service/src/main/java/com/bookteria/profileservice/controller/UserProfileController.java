package com.bookteria.profileservice.controller;

import com.bookteria.profileservice.dto.request.ProfileCreationRequest;
import com.bookteria.profileservice.dto.response.UserProfileResponse;
import com.bookteria.profileservice.service.UserProfileService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserProfileController {
    UserProfileService userProfileService;

    @PostMapping("/users")
    UserProfileResponse createProfile(@RequestBody ProfileCreationRequest request) {
        return userProfileService.createProfile(request);
    }

    @GetMapping("/users/{profileId}")
    UserProfileResponse getProfile(@PathVariable String profileId) {
        return userProfileService.getUserProfileById(profileId);
    }
}
