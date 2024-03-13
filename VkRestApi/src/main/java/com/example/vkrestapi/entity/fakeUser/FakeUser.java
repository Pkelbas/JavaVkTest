package com.example.vkrestapi.entity.fakeUser;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FakeUser {
  private Integer id;
  private String name;
  private String username;
  private String email;

  private Adress adress;

  private String phone;

  private String website;

  private Company company;
}
