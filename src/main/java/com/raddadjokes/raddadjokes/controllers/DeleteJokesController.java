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
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
@RequestMapping("delete-jokes")
public class DeleteJokesController {

    @Autowired
    private JokeRepository jokeRepository;

    @Autowired
    private UserRepository userRepository;

    //    6/8 Adria - Copied and modified from CodingEvents with LC Chris
    @GetMapping
    public String displayDeleteJokesPage(Model model, Authentication authentication) {

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        String email = userDetails.getUsername();
        User user = userRepository.findByEmail(email);
        System.out.println(user.getId());
        Integer userId = user.getId();

        Collection<Joke> userJokes = jokeRepository.findJokeByUserId(userId);
        for(Joke joke:userJokes){
            model.addAttribute("joke", joke);
            System.out.println(joke.toString());
        }
//        model.addAttribute("title", "Delete Jokes");
        model.addAttribute("user", user);
        model.addAttribute("userJokes", userJokes);

        return ("/delete-jokes");
    }

    @PostMapping("delete")
    public String processDeleteJoke(@RequestParam(required = false) int[] userJokes) {

        if (userJokes != null) {
            for (int id : userJokes) {
                jokeRepository.deleteById(id);
            }
        }
        return ("/delete-jokes/success");
    }

}
