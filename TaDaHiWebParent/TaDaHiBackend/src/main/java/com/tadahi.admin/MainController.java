package com.tadahi.admin;

import org.springframework.stereotype.Controller;

@Controller
public class MainController {
    public String viewHomePage(){
        return "index";
    }
}
