package com.BrushCircle.model.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    public TestController() {
    }

    @RequestMapping("/echo")
    @ResponseBody
    public String echoResponse(){
        return "Hello World";
    }
}
