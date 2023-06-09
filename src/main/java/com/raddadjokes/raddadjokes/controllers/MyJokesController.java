package com.raddadjokes.raddadjokes.controllers;

import com.raddadjokes.raddadjokes.data.JokeRepository;
import com.raddadjokes.raddadjokes.data.UserRepository;
import com.raddadjokes.raddadjokes.models.Joke;
import com.raddadjokes.raddadjokes.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/my-jokes")
public class MyJokesController {
    @Autowired
    private JokeRepository jokeRepository;

    @Autowired
    private UserRepository userRepository;


    @GetMapping
    public String showMyJokes(Model model, Authentication authentication){


        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        String email = userDetails.getUsername();
        User user = userRepository.findByEmail(email);
        System.out.println(user.getId());
        Integer userId = user.getId();


//        Collection<Joke> userJokes = (Collection<Long>) jokeRepository.findJokeIdsByUserId(user.getId());
//        System.out.println(userJokes);

        Collection<Joke> userJokes = jokeRepository.findJokeByUserId(userId);
        for(Joke joke:userJokes){
            model.addAttribute("joke", joke);
            System.out.println(joke.toString());
        }
//        System.out.println(userJokes);
//        System.out.println(user.getUsername());
//        System.out.println(user.getUserJokes());
//        user.setUserJokes(userJokes);
//        userRepository.save(user);

//        for (Integer jokeID: user.getUserJokes(){
//            System.out.println(jokeRepository.findJokeById());
//        }

        model.addAttribute("user", user);
        model.addAttribute("userJokes", userJokes);

        return ("my-jokes");
    }


}
