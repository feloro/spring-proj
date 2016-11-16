package com.myapp.controller

import com.myapp.service.AuthService
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
class MainController{

    @Autowired
    AuthService authService;

    @ResponseBody
    @RequestMapping(value = "/welcome", method = [RequestMethod.GET])
    public LinkedHashMap welcomePage(ModelMap map)
    {
        return [id: 1, name: 'test'];
    }
}