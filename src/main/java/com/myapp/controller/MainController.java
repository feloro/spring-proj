package com.myapp.controller;

import com.myapp.database.entity.User;
import com.myapp.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
class MainController {

  @Autowired
  AuthService authService;

  @ResponseBody
  @GetMapping(value = "/welcome")
  public List<Map> welcomePage() {
    List<Map> responseUsers = new ArrayList<>();
    authService.getUsers().forEach((User user) -> {
      HashMap<String, Object> responseUser = new HashMap();
      responseUser.put("id", user.getId());
      responseUser.put("email", user.getEmail());
      responseUsers.add(responseUser);
    });
    return responseUsers;
  }
}