package com.example.vkrestapi.audit;

import com.example.vkrestapi.repository.AuditRepository;
import jakarta.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Order(1)
@Component
@RequiredArgsConstructor
public class AuditAspect {

  private final AuditRepository repository;

  @Before("@annotation(Audit)")
  public void audit(JoinPoint joinPoint){
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    HttpServletRequest request = ((ServletRequestAttributes )RequestContextHolder.getRequestAttributes()).getRequest();
    String username = authentication.getName();
    String method = request.getMethod();
    String url = request.getRequestURI();
    LocalDateTime time = LocalDateTime.now();

    AuditLog log = new AuditLog();
    log.setTime(time);
    log.setUsername(username);
    log.setRequestUrl(url);
    log.setRequestMethod(method);
    repository.save(log);

  }

}
