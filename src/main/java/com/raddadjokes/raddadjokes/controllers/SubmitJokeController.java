package com.raddadjokes.raddadjokes.controllers;

import com.raddadjokes.raddadjokes.models.JokeModel;
import com.raddadjokes.raddadjokes.models.data.JokeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class SubmitJokeController {
    @Autowired
    JokeRepository jokeRepository;

    public SubmitJokeController(JokeRepository jokeRepository) {
        this.jokeRepository = jokeRepository;
    }


    public ResponseEntity<String> addJoke(@RequestBody JokeModel.JokeInput jokeInput) {
        String setup = jokeInput.getSetup();
        String punchline = jokeInput.getPunchline();

        JokeModel.Joke joke = new JokeModel.Joke(setup, punchline);
        jokeRepository.save(joke);

        return ResponseEntity.ok("Joke added successfully!");
    }
}
