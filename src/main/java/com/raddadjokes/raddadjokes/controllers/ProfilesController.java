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
@RequestMapping("/profiles")
public class ProfilesController {

    @Autowired
    private ProfilesRepository profileRepository;

    @GetMapping
    public String showProfiles(Model model, HttpSession session) {
//Temp comment out
//        String username = (String) session.getAttribute("username");
//        Profiles profile = profileRepository.findByUsername(username);

        // Add the profile to the model?
        // model.addAttribute("profile", profile);


        //alt method that works
//        model.addAttribute("username", profile.getUsername());
//        model.addAttribute("email", profile.getEmail());

        // Return the profile page view
        return "/profiles";
    }

//    @PostMapping("/update")
//    public String updateProfile(
//            @RequestParam("username") String username,
//            @RequestParam("email") String email,
//            @RequestParam("password") String password
//    ) {
//        Profiles profile = profileRepository.findByUsername(username);
//
//        // Update the profile with the new values
//        // profile.setUsername(username);
//        // profile.setEmail(email);
//        // profile.setPassword(password);
//
//        // Save the updated profile to the repository
//        // profileRepository.save(profile);
//
//        // Redirect back to the profile page
//        return "redirect:/profile";
//    }
}