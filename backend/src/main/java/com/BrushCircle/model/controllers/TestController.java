package com.BrushCircle.model.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    public TestController() {
    }

    @RequestMapping("/")
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:3000")
    public String echoResponse(){
        return "Hello Team 1";
    }
}
