package com.mebitech.company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Welcome {

    @GetMapping("/welcome")
    public String welcome(Model md){

        md.addAttribute("title","Meeting Application");
        return "welcome";
    }
}
