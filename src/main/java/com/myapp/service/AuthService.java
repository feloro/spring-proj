package com.myapp.service;

import com.myapp.database.entity.User;
import com.myapp.database.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

  public Map<String, Object> saveUser(User user) {
    Map<String, Object> response = new HashMap<>();
    user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
    User saved = userRepository.saveAndFlush(user);
    response.put("id", saved.getId());
    return response;
  }

  public Boolean deleteUser(Long id) {
    userRepository.delete(id);
    return true;
  }

  public User getUser(Long id) {
    return userRepository.findOne(id);
  }
}
