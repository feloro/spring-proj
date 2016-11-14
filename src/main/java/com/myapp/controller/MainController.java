package com.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
class MainController{

    @RequestMapping(value = "/welcome")
    public String welcomePage(ModelMap map)
    {
        map.put("test", "test");
        return "index";
    }
}