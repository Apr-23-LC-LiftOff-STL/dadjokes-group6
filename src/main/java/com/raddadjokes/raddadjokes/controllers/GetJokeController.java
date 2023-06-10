package com.raddadjokes.raddadjokes.controllers;

import com.raddadjokes.raddadjokes.data.JokeRepository;
import com.raddadjokes.raddadjokes.data.UserRepository;
import com.raddadjokes.raddadjokes.models.Joke;
import com.raddadjokes.raddadjokes.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/")
public class GetJokeController {

    @Autowired
    private JokeRepository jokeRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String showGetJoke(Model model, Authentication authentication){

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        String email = userDetails.getUsername();
        User user = userRepository.findByEmail(email);


        Joke joke = jokeRepository.findRandomJoke();
        System.out.println(joke.toString());
        model.addAttribute("joke", joke);
        model.addAttribute("user", userRepository.findUserById(joke.getUserId()));

        return ("index");
    }

}
