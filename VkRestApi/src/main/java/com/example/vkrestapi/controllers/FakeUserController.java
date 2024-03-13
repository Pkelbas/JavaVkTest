package com.example.vkrestapi.controllers;

import com.example.vkrestapi.audit.Audit;
import com.example.vkrestapi.entity.Album;
import com.example.vkrestapi.entity.fakeUser.FakeUser;
import com.example.vkrestapi.services.AlbumService;
import com.example.vkrestapi.services.FakeUserService;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/api/users")
public class FakeUserController {
  private final FakeUserService service;

  @Audit
  @Cacheable("user-get")
  @GetMapping("/{id}")
  public FakeUser get(@PathVariable Integer id){
    return service.get(id);
  }

  @Audit
  @Cacheable("user-put")
  @PutMapping("/{id}")
  public void put(@PathVariable Integer id, @RequestParam FakeUser user){
    service.put(id, user);
  }
  @Audit
  @Cacheable("user-post")
  @PostMapping("/{id}")
  public void post(@RequestParam FakeUser user){
    service.post(user);
  }
  @Audit
  @Cacheable("user-delete")
  @DeleteMapping("/{id}")
  public void delete(@PathVariable Integer id){
    service.delete(id);
  }
}
