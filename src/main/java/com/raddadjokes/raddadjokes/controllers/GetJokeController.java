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
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Collection;


@Controller
@RequestMapping("/")
public class GetJokeController {

    @Autowired
    private JokeRepository jokeRepository;

    @Autowired
    private UserRepository userRepository;

    public String showGetJoke(Model model, Authentication authentication){
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        String email = userDetails.getUsername();
        User user = userRepository.findByEmail(email);
        System.out.println(user.getId());
        Integer userId = user.getId();


//        Joke randJoke = jokeRepository.findJokeByRandId();
//        for(Joke joke:randJoke){
//            model.addAttribute("joke", joke);
//            System.out.println(joke.toString());
//        }
        model.addAttribute("user", user);
        Joke randomJoke = jokeRepository.findRandomJoke();
        model.addAttribute("jokes", randomJoke);

        return ("/");
    }

}
