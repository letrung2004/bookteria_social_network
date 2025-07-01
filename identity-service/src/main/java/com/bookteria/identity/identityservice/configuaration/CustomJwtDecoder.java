package com.bookteria.identity.identityservice.configuaration;

import java.text.ParseException;

import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtException;
import org.springframework.stereotype.Component;

import com.bookteria.identity.identityservice.service.AuthenticationService;
import com.nimbusds.jwt.SignedJWT;

@Component
public class CustomJwtDecoder implements JwtDecoder {
    private final AuthenticationService authenticationService;

    public CustomJwtDecoder(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @Override
    public Jwt decode(String token) throws JwtException {
        try {
            SignedJWT signedJWT = SignedJWT.parse(token);

            return new Jwt(
                    token,
                    signedJWT.getJWTClaimsSet().getIssueTime().toInstant(),
                    signedJWT.getJWTClaimsSet().getExpirationTime().toInstant(),
                    signedJWT.getHeader().toJSONObject(),
                    signedJWT.getJWTClaimsSet().getClaims());
        } catch (ParseException e) {
            throw new JwtException("Invalid JWT", e);
        }
    }
}
