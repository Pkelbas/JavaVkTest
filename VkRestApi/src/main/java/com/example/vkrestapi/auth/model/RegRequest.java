package com.example.vkrestapi.auth.model;

import com.example.vkrestapi.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegRequest {

  private String username;
  private String password;

  private Role role;
}