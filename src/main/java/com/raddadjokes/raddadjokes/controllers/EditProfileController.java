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
        return "edit-profile";
    }


    @PostMapping("/update")
    public String updateProfile(
            @RequestParam("username") String username,
            @RequestParam("email") String email,
            @RequestParam("password") String password
    ) {
        // Retrieve the profile from the repository (assuming you have the user's ID or username)
        // For example, if you have the username, you can retrieve the profile like this:
        // Profile profile = profileRepository.findByUsername(username);

        // Update the profile with the new values
        // profile.setUsername(username);
        // profile.setEmail(email);
        // profile.setPassword(password); // Remember to hash or encrypt the password before storing

        // Save the updated profile to the repository
        // profileRepository.save(profile);

        // Redirect back to the profile page
        return "redirect:/profile";
    }
}
