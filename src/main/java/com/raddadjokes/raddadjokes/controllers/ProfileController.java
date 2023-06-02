package com.raddadjokes.raddadjokes.controllers;

import com.raddadjokes.raddadjokes.models.Profiles;
import com.raddadjokes.raddadjokes.data.ProfilesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private ProfilesRepository profileRepository;

    @GetMapping("/profile")
    public String showProfile(Model model, HttpSession session) {

        String username = (String) session.getAttribute("username");

        Profiles profile = profileRepository.findByUsername(username);

        // Add the profile to the model?
        model.addAttribute("profile", profile);


        //alt method that works
        model.addAttribute("username", profile.getUsername());
        model.addAttribute("email", profile.getEmail());

        // Return the profile page view
        return "profile";
    }


}
