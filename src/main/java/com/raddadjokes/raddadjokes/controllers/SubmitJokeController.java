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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.constraints.Null;
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
        Long userId = user.getId();
        Joke newJoke = new Joke();

        Collection userJokes = user.getUserJokes();
        System.out.println("username: " + user.getUsername());
        System.out.println("user email: " + user.getEmail());
        System.out.println("user ID: " + user.getId());
        System.out.println("user jokes: " + user.getUserJokes());

        model.addAttribute("user", user);
        model.addAttribute("userJokes", userJokes);
        model.addAttribute("newJoke", newJoke);
        model.addAttribute("userId",userId);

        return ("/submit-joke");
    }
//    @PostMapping("")
//    public String saveJoke(@ModelAttribute Joke newJoke, Authentication authentication){
//
//    UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//
//    String email = userDetails.getUsername();
//    User user = userRepository.findByEmail(email);
//    Long userId = user.getId();
//        System.out.println(userId);
//
////    newJoke.setId(userId);
//        System.out.println(newJoke.getSetup());
//        System.out.println(newJoke.getPunchline());
//        System.out.println(newJoke.getNsfw());
//    jokeRepository.save(newJoke);
//
//
//    return "redirect:/registration?success";
//    }
    @PostMapping("/submit-joke")
    public String processSubmitJoke(@ModelAttribute Joke newJoke, Authentication authentication){

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        String email = userDetails.getUsername();
        User user = userRepository.findByEmail(email);
        newJoke.setUserId(user.getId());

//        String setup = newJoke.getSetup();
//        String punchLine = newJoke.getPunchline();
        jokeRepository.save(newJoke);
//        System.out.println(userDetails);
        return "redirect:/my-jokes";

//        return "/submit-joke";
    };
}
