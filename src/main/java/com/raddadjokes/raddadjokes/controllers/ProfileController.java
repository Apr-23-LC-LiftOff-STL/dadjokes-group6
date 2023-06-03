package com.raddadjokes.raddadjokes.controllers;

import com.raddadjokes.raddadjokes.models.Profile;
import com.raddadjokes.raddadjokes.data.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private ProfileRepository profileRepository;

    @GetMapping("/profile")
    public String showProfile(Model model, HttpSession session) {

        String username = (String) session.getAttribute("username");

        Profile profile = profileRepository.findByUsername(username);

        // Add the profile to the model?
        model.addAttribute("profile", profile);


        //alt method that works
        model.addAttribute("username", profile.getUsername());
        model.addAttribute("email", profile.getEmail());

        // Return the profile page view
        return "profile";
    }


}