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

    @PostMapping("/profile/update")
    public String updateProfile(
            @RequestParam("username") String username,
            @RequestParam("email") String email,
            HttpSession session
    ) {
        String loggedInUsername = (String) session.getAttribute("username");

        // Check if the logged-in user matches the edited profile
        if (loggedInUsername.equals(username)) {
            // Retrieve the user profile from the UserRepository
            Profiles user = profileRepository.findByUsername(username);

            // Update the profile with the new email

            // Save the updated profile to the UserRepository

            // Handle success/failure and provide appropriate feedback

            return "redirect:/profile"; // Redirect back to the profile page
        } else {
            // Handle unauthorized access to the profile update
            return "error"; // Return the name of the error template
        }
    }
}
