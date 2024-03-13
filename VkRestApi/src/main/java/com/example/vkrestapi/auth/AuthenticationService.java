package com.example.vkrestapi.auth;

import com.example.vkrestapi.auth.model.AuthRequest;
import com.example.vkrestapi.auth.model.AuthResponse;
import com.example.vkrestapi.auth.model.RegRequest;
import com.example.vkrestapi.entity.User;
import com.example.vkrestapi.repository.UserRepository;
import com.example.vkrestapi.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

  private final UserRepository repository;
  private final PasswordEncoder encoder;
  private final AuthenticationManager manager;
  private final JwtService service;

  public AuthResponse register(RegRequest request) {
    var user = User.builder()
        .username(request.getUsername())
        .password(encoder.encode(request.getPassword()))
        .role(request.getRole())
        .build();
    repository.save(user);
    var jwtToken = service.generateToken(user);
    return AuthResponse.builder().token(jwtToken).build();
  }

  public AuthResponse authenticate(AuthRequest request) {
    manager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
    var user = repository.findByUsername(request.getUsername()).orElseThrow();
    var jwtToken = service.generateToken(user);
    return AuthResponse.builder().token(jwtToken).build();
  }
}