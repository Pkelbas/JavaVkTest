package com.example.vkrestapi.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Permission {
  ALBUMS_READ("albums:read"),
  ALBUMS_UPDATE("albums:update"),
  ALBUMS_CREATE("albums:create"),
  ALBUMS_DELETE("albums:delete"),
  POSTS_READ("posts:read"),
  POSTS_UPDATE("posts:update"),
  POSTS_CREATE("posts:create"),
  POSTS_DELETE("posts:delete"),
  USERS_READ("users:read"),
  USERS_UPDATE("users:update"),
  USERS_CREATE("users:create"),
  USERS_DELETE("users:delete")

  ;

  @Getter
  private final String permission;
}