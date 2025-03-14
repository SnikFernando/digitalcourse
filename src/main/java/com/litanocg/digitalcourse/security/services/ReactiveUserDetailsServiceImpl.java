package com.litanocg.digitalcourse.security.services;

import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import reactor.core.publisher.Mono;

public class ReactiveUserDetailsServiceImpl implements ReactiveUserDetailsService {
    @Override
    public Mono<UserDetails> findByUsername(String username) {
        // Implementar lógica reactiva para buscar usuario desde la base de datos

        return Mono.empty();
    }
}
