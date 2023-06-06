package com.raddadjokes.raddadjokes.controllers;

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

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String showProfile(Model model, Authentication authentication) {
//Temp comment out
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        String email = userDetails.getUsername();
        User user = userRepository.findByEmail(email);
        Joke newJoke = new Joke();

        String userName = user.getUsername();
        String userEmail = user.getEmail();

//         Add the profile to the model?
         model.addAttribute("user", user);
         model.addAttribute("username", userName);
         model.addAttribute("email", userEmail);


        //alt method that works
//        model.addAttribute("username", profile.getUsername());
//        model.addAttribute("email", profile.getEmail());

        // Return the profile page view
        return "/profile";
    }

}