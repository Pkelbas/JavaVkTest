package com.example.vkrestapi.entity;

import static com.example.vkrestapi.entity.Permission.ALBUMS_CREATE;
import static com.example.vkrestapi.entity.Permission.ALBUMS_DELETE;
import static com.example.vkrestapi.entity.Permission.ALBUMS_READ;
import static com.example.vkrestapi.entity.Permission.ALBUMS_UPDATE;
import static com.example.vkrestapi.entity.Permission.POSTS_CREATE;
import static com.example.vkrestapi.entity.Permission.POSTS_DELETE;
import static com.example.vkrestapi.entity.Permission.POSTS_READ;
import static com.example.vkrestapi.entity.Permission.POSTS_UPDATE;
import static com.example.vkrestapi.entity.Permission.USERS_CREATE;
import static com.example.vkrestapi.entity.Permission.USERS_DELETE;
import static com.example.vkrestapi.entity.Permission.USERS_READ;
import static com.example.vkrestapi.entity.Permission.USERS_UPDATE;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@RequiredArgsConstructor
public enum Role {
  ADMIN(
      Set.of(
          ALBUMS_READ,
          ALBUMS_UPDATE,
          ALBUMS_DELETE,
          ALBUMS_CREATE,
          USERS_UPDATE,
          USERS_DELETE,
          USERS_CREATE,
          USERS_READ,
          POSTS_READ,
          POSTS_UPDATE,
          POSTS_CREATE,
          POSTS_DELETE
      )
  ),
  ALBUMS(
      Set.of(
          ALBUMS_READ,
          ALBUMS_UPDATE,
          ALBUMS_DELETE,
          ALBUMS_CREATE
      )
  ),

  POSTS(
      Set.of(
          POSTS_READ,
          POSTS_UPDATE,
          POSTS_CREATE,
          POSTS_DELETE
      )
  ),

  USERS(
      Set.of(
          USERS_UPDATE,
          USERS_DELETE,
          USERS_CREATE,
          USERS_READ
      )
  );

  @Getter
  private final Set<Permission> permissions;

  public List<SimpleGrantedAuthority> getAuthorities() {
    var authorities = getPermissions()
        .stream()
        .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
        .collect(Collectors.toList());
    authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
    return authorities;
  }
}