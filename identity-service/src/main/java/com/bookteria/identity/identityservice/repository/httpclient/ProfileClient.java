package com.bookteria.identity.identityservice.repository.httpclient;

import com.bookteria.identity.identityservice.dto.request.ProfileCreationRequest;
import com.bookteria.identity.identityservice.dto.response.UserProfileResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "profile-service", url = "${app.services.profile}")
public interface ProfileClient {
    @PostMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    UserProfileResponse createProfile(@RequestBody ProfileCreationRequest request);
}
