package com.example.vkrestapi.security;


import static com.example.vkrestapi.entity.Permission.ALBUMS_CREATE;
import static com.example.vkrestapi.entity.Permission.ALBUMS_DELETE;
import static com.example.vkrestapi.entity.Permission.ALBUMS_READ;
import static com.example.vkrestapi.entity.Permission.POSTS_CREATE;
import static com.example.vkrestapi.entity.Permission.POSTS_DELETE;
import static com.example.vkrestapi.entity.Permission.POSTS_READ;
import static com.example.vkrestapi.entity.Permission.POSTS_UPDATE;
import static com.example.vkrestapi.entity.Permission.USERS_CREATE;
import static com.example.vkrestapi.entity.Permission.USERS_DELETE;
import static com.example.vkrestapi.entity.Permission.USERS_READ;
import static com.example.vkrestapi.entity.Permission.USERS_UPDATE;
import static com.example.vkrestapi.entity.Role.ADMIN;
import static org.springframework.http.HttpMethod.DELETE;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.HttpMethod.PUT;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
  private final JwtAuthFilter jwtAuthFilter;
  private final AuthenticationProvider authenticationProvider;

  private static final String [] WHITE_LIST_URL = {"/v1/auth/**"};
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

    httpSecurity
        .csrf(AbstractHttpConfigurer::disable)
        .authorizeHttpRequests(req ->
            req.requestMatchers(WHITE_LIST_URL).permitAll()
                .requestMatchers("/test-controller/**").hasRole(ADMIN.name())
                .requestMatchers(GET, "/v1/api/posts/**").hasAnyAuthority(POSTS_READ.name())
                .requestMatchers(POST, "/v1/api/posts/**").hasAnyAuthority(POSTS_CREATE.name())
                .requestMatchers(DELETE, "/v1/api/posts/**").hasAnyAuthority(POSTS_DELETE.name())
                .requestMatchers(PUT, "/v1/api/posts/**").hasAnyAuthority(POSTS_UPDATE.name())
                .requestMatchers(GET, "/v1/api/albums/**").hasAnyAuthority(ALBUMS_READ.name())
                .requestMatchers(POST, "/v1/api/albums/**").hasAnyAuthority(ALBUMS_CREATE.name())
                .requestMatchers(DELETE, "/v1/api/albums/**").hasAnyAuthority(ALBUMS_DELETE.name())
                .requestMatchers(PUT, "/v1/api/albums/**").hasAnyAuthority(ALBUMS_DELETE.name())
                .requestMatchers(GET, "/v1/api/users/**").hasAnyAuthority(USERS_READ.name())
                .requestMatchers(POST, "/v1/api/users/**").hasAnyAuthority(USERS_CREATE.name())
                .requestMatchers(DELETE, "/v1/api/users/**").hasAnyAuthority(USERS_DELETE.name())
                .requestMatchers(PUT, "/v1/api/users/**").hasAnyAuthority(USERS_UPDATE.name())
                .anyRequest()
                .authenticated())
        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .authenticationProvider(authenticationProvider)
        .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
    return httpSecurity.build();
  }
}