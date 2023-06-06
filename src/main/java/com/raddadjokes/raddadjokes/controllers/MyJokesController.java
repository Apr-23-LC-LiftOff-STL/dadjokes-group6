package com.raddadjokes.raddadjokes.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/my-jokes")
public class MyJokesController {

    public String showMyJokes(Model model, HttpSession session){


        return ("/my-jokes");
    }
}
