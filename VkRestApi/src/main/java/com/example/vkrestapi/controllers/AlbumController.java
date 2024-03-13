package com.example.vkrestapi.controllers;

import com.example.vkrestapi.audit.Audit;
import com.example.vkrestapi.entity.Album;
import com.example.vkrestapi.services.AlbumService;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/api/albums")
public class AlbumController {

  private final AlbumService service;

  @Audit
  @Cacheable("album-get")
  @GetMapping("/{id}")
  public Album get(@PathVariable Integer id){
    return service.get(id);
  }

  @Audit
  @Cacheable("album-put")
  @GetMapping("/{id}")
  public void put(@PathVariable Integer id, @RequestParam Album album){
    service.put(id, album);
  }
  @Audit
  @Cacheable("album-post")
  @GetMapping("/{id}")
  public void post(@RequestParam Album album){
    service.post(album);
  }
  @Audit
  @Cacheable("album-delete")
  @GetMapping("/{id}")
  public void delete(@PathVariable Integer id){
    service.delete(id);
  }

}
