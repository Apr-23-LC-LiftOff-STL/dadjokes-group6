package com.raddadjokes.raddadjokes.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/about")
public class AboutController {

    @GetMapping
    public String showAbout(Model model, HttpSession session){


        return ("about");
    }
}
