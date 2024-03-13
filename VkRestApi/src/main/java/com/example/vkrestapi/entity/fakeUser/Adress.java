package com.example.vkrestapi.entity.fakeUser;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Adress {

  private String street;

  private String suite;

  private String city;

  private String zipcode;

  private Geo geo;

}
