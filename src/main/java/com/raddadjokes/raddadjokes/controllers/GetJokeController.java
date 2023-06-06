package com.raddadjokes.raddadjokes.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

//might want to refactor the front end to be set up as pages instead of tabs, so we can use @RequestMapping like we did in the coding events demo
@Controller
@RequestMapping("/")
public class GetJokeController {

    public String showGetJoke(Model model, HttpSession session){


        return ("/");
    }

}
