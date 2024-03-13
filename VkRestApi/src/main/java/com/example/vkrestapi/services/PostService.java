package com.example.vkrestapi.services;

import com.example.vkrestapi.entity.Post;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class PostService {

  @Value("${json.placeholder.path}")
  private String urlPath;

  private final RestTemplate restTemplate;

  public PostService() {
    urlPath += "posts/";
    restTemplate = new RestTemplate();
  }

  public Post get(Integer id) {
    return restTemplate.getForEntity(urlPath + id, Post.class).getBody();
  }

  public void post(Post post) {
    restTemplate.postForEntity(urlPath, post, Post.class);
  }

  public void put(Integer id, Post post) {
    restTemplate.put(urlPath + id, post);
  }

  public void delete(Integer id) {
    restTemplate.delete(urlPath + id);
  }
}
