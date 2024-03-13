package com.example.vkrestapi.services;

import com.example.vkrestapi.entity.Album;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AlbumService {
  @Value("${json.placeholder.path}")
  private String urlPath;

  private final RestTemplate restTemplate;

  public AlbumService(){
    urlPath += "albums/";
    restTemplate = new RestTemplate();
  }


  public Album get(Integer id){
    return restTemplate.getForEntity(urlPath + id, Album.class).getBody();
  }

  public void post(Album album){
    restTemplate.postForEntity(urlPath, album, Album.class);
  }

  public void put(Integer id, Album album){
    restTemplate.put(urlPath + id, album);
  }

  public void delete(Integer id){
    restTemplate.delete(urlPath + id);
  }

}
