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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Collection;

@Controller
@RequestMapping("/submit-joke")
public class SubmitJokeController {
    @Autowired
    private JokeRepository jokeRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String showSubmitJoke(Model model, Authentication authentication){

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        String email = userDetails.getUsername();
        User user = userRepository.findByEmail(email);
        Joke newJoke = new Joke();

        Collection userJokes = user.getUserJokes();
        System.out.println(user.getUsername());
        System.out.println(user.getUserJokes());

        model.addAttribute("user", user);
        model.addAttribute("userJokes", userJokes);

        return ("/submit-joke");
    }
@PostMapping
    public String saveJoke(Model model, Authentication authentication){

    UserDetails userDetails = (UserDetails) authentication.getPrincipal();


    return "redirect:/registration?success";
    }
}
