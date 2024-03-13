package com.example.vkrestapi.services;

import com.example.vkrestapi.entity.fakeUser.FakeUser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FakeUserService {

  @Value("${json.placeholder.path}")
  private String urlPath;

  private final RestTemplate restTemplate;

  public FakeUserService() {
    urlPath += "users/";
    restTemplate = new RestTemplate();
  }

  public FakeUser get(Integer id) {
    return restTemplate.getForEntity(urlPath + id, FakeUser.class).getBody();
  }

  public void post(FakeUser user) {
    restTemplate.postForEntity(urlPath, user, FakeUser.class);
  }

  public void put(Integer id, FakeUser user) {
    restTemplate.put(urlPath + id, user);
  }

  public void delete(Integer id) {
    restTemplate.delete(urlPath + id);
  }
}
