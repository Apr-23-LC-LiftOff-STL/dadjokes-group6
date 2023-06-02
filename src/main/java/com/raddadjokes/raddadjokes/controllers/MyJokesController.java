package com.raddadjokes.raddadjokes.controllers;

import com.raddadjokes.raddadjokes.data.JokesRepository;
import com.raddadjokes.raddadjokes.data.ProfilesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/my-jokes")
public class MyJokesController {
    @Autowired
    private JokesRepository jokesRepository;

    @Autowired
    private ProfilesRepository profilesRepository;

    @GetMapping
    public String showMyJokes(Model model, HttpSession session){


        return ("/my-jokes");
    }
}
