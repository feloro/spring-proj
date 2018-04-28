package com.myapp.service;

import com.myapp.database.entity.User;
import com.myapp.database.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by istomin.a on 16.11.2016.
 */
@Component
@Service
public class AuthService {

  @Autowired
  UserRepository userRepository;

  public List<User> getUsers(){
    return userRepository.findAll();
  }
}
