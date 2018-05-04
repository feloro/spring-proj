package com.myapp.controller;

import com.myapp.database.entity.User;
import com.myapp.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {

  @Autowired
  AuthService authService;

  @ResponseBody
  @GetMapping(value = "/users")
  public List<Map> welcomePage() {
    List<Map> responseUsers = new ArrayList<>();
    authService.getUsers().forEach((User user) -> {
      HashMap<String, Object> responseUser = new HashMap();
      responseUser.put("id", user.getId());
      responseUser.put("email", user.getEmail());
      responseUser.put("name", user.getLogin());
      responseUsers.add(responseUser);
    });
    return responseUsers;
  }

  @ResponseBody
  @PutMapping(value = "/users")
  public Map<String, Object> saveUser (@RequestBody User user) {
    return authService.saveUser(user);
  }

  @ResponseBody
  @DeleteMapping(value = "/users/{id}")
  public Map<String, Object> deleteUser(@PathVariable("id") Long id) {
    Map<String, Object> response = new HashMap<>();
    response.put("success", authService.deleteUser(id));
    return response;
  }

  @ResponseBody
  @GetMapping(value = "/users/{id}")
  public Map<String, Object> getUser(@PathVariable("id") Long id) {
    User user = authService.getUser(id);
    HashMap<String, Object> responseUser = new HashMap<>();
    responseUser.put("id", user.getId());
    responseUser.put("email", user.getEmail());
    responseUser.put("name", user.getLogin());
    return responseUser;
  }
}