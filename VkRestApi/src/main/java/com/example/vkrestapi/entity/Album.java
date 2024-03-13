package com.example.vkrestapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Album {
  private Integer userId;
  private Integer id;
  private String name;
}
