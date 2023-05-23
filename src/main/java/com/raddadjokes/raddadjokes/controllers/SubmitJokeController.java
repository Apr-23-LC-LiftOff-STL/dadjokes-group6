package com.raddadjokes.raddadjokes.controllers;

import com.raddadjokes.raddadjokes.models.JokeModel;
import com.raddadjokes.raddadjokes.models.data.JokeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SubmitJokeController {
    @Autowired
    JokeRepository jokeRepository;

    public SubmitJokeController(JokeRepository jokeRepository) {
        this.jokeRepository = jokeRepository;
    }

    @GetMapping
    public String addJokeForm(Model model) {
        String setup = JokeModel.getSetup();
        String punchline = JokeModel.getPunchline();
        model.addAttribute("setup", new JokeModel().setSetup(setup));
        model.addAttribute("punchline", new JokeModel().setPunchline(punchline));
        return null;
    }
}
