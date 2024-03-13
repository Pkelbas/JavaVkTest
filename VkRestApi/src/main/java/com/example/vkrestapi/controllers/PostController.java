package com.example.vkrestapi.controllers;

import com.example.vkrestapi.audit.Audit;
import com.example.vkrestapi.entity.Post;
import com.example.vkrestapi.services.PostService;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/api/posts")
public class PostController {

  private final PostService service;

  @Audit
  @Cacheable("post-get")
  @GetMapping("/{id}")
  public Post get(@PathVariable Integer id) {
    return service.get(id);
  }

  @Audit
  @Cacheable("post-put")
  @GetMapping("/{id}")
  public void put(@PathVariable Integer id, @RequestParam Post post) {
    service.put(id, post);
  }

  @Audit
  @Cacheable("post-post")
  @GetMapping("/{id}")
  public void post(@RequestParam Post post) {
    service.post(post);
  }

  @Audit
  @Cacheable("post-delete")
  @GetMapping("/{id}")
  public void delete(@PathVariable Integer id) {
    service.delete(id);
  }
}
