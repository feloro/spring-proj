package com.myapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

/**
 * Created by anton.istomin on 27.04.2018.
 */
@Configuration
@EnableWebSecurity
public class WebSecurity implements AuthenticationManager{


  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    return null;
  }
}
