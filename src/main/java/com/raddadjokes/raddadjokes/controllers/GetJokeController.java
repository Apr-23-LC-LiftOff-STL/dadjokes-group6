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

import java.util.List;

//might want to refactor the front end to be set up as pages instead of tabs, so we can use @RequestMapping like we did in the coding events demo
@Controller
@RequestMapping("/")
public class GetJokeController {

    @Autowired
    private JokeRepository jokeRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String showGetJoke(Model model, Authentication authentication){

        System.out.println("****is the console log working?");
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        String email = userDetails.getUsername();
        User user = userRepository.findByEmail(email);
//        System.out.println(user.getId());
//        Integer userId = user.getId();


        List<Joke> randJoke = jokeRepository.findRandomJoke();
        for(Joke joke:randJoke){
//            model.addAttribute("joke", joke);
            System.out.println(joke.toString());
        }
        model.addAttribute("user", user);
//        Joke randomJoke = jokeRepository.findRandomJoke();
//        System.out.println("***CHECK JOKE*** " + randomJoke.toString());
//        Integer jokeUserId = randomJoke.getUserId();
//        String jokeAuthor = userRepository.findUsernameById(jokeUserId);
//        model.addAttribute("joke", randomJoke);
//        model.addAttribute("jokeAuthor", jokeAuthor);

        return ("index");
    }

}
