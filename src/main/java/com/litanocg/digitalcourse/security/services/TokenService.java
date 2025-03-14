package com.litanocg.digitalcourse.security.services;

import com.litanocg.digitalcourse.security.model.UserPrincipal;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class TokenService implements Converter<Jwt, Mono<? extends AbstractAuthenticationToken>> {
    @Override
    public Mono<? extends AbstractAuthenticationToken> convert(Jwt jwt) {
        UserPrincipal userPrincipal = new UserPrincipal(jwt.getSubject(), jwt.getClaim("email"), "");
        return Mono.just(new UsernamePasswordAuthenticationToken(userPrincipal, jwt.getTokenValue(), userPrincipal.getAuthorities()));
    }
}
