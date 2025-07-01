package com.bookteria.identity.identityservice.repository.httpclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bookteria.identity.identityservice.configuaration.AuthenticationRequestInterceptor;
import com.bookteria.identity.identityservice.dto.request.ProfileCreationRequest;
import com.bookteria.identity.identityservice.dto.response.UserProfileResponse;

@FeignClient(
        name = "profile-service",
        url = "${app.services.profile}",
        configuration = {AuthenticationRequestInterceptor.class})
public interface ProfileClient {
    @PostMapping(value = "/internal/users", produces = MediaType.APPLICATION_JSON_VALUE)
    UserProfileResponse createProfile(@RequestBody ProfileCreationRequest request);
}
