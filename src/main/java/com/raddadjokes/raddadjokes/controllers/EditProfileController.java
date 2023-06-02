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
public class EditProfileController {
    @Autowired
    private ProfilesRepository profileRepository;

    @GetMapping("/edit")
    public String showEditProfileForm(Model model, HttpSession session) {

        String username = (String) session.getAttribute("username");

        // Retrieve the profile from the repository based on the username
        Profiles profile = profileRepository.findByUsername(username);

        // Add the profile to the model
        model.addAttribute("profile", profile);

        // Return the edit profile form view
        return "edit-profiles";
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
