package com.mebitech.company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Welcome {

    @GetMapping("/welcome")
    @ResponseBody
    public String welcome(){
        System.out.println("i conttroller");
        return "welcome";
    }
}
