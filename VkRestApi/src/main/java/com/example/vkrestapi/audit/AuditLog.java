package com.example.vkrestapi.audit;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name ="audit")
public class AuditLog {


  @Id
  @GeneratedValue
  public Integer id;

  public LocalDateTime time;

  public String username;

  public String requestMethod;

  public String requestUrl;


}
