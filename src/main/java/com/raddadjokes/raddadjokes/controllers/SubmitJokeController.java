package com.raddadjokes.raddadjokes.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/submit-joke")
public class SubmitJokeController {
//    @Autowired
//    private JokesRepository jokesRepository;
//
//    @Autowired
//    private ProfilesRepository profilesRepository;

    @GetMapping
    public String showSubmitJoke(Model model, HttpSession session){


        return ("/submit-joke");
    }
}
