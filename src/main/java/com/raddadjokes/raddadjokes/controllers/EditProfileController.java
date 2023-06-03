package com.raddadjokes.raddadjokes.controllers;

import com.raddadjokes.raddadjokes.models.Profile;
import com.raddadjokes.raddadjokes.data.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;



@Controller
@RequestMapping("/profile")
public class EditProfileController {
    @Autowired
    private ProfileRepository profileRepository;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @GetMapping("/edit")
    public String showEditProfileForm(Model model, HttpSession session) {

        String username = (String) session.getAttribute("username");

        // Retrieve the profile from the repository based on the username
        Profile profile = profileRepository.findByUsername(username);

        // Add the profile to the model
        model.addAttribute("profile", profile);

        // Return the edit profile form view
        return "edit-profiles";
    }


    @PostMapping("/profile/update")
    public String updateProfile(
            @Valid Profile profile,
            BindingResult bindingResult,
            HttpSession session,
            Model model
    ) {

        Profile sessionUser = (Profile) session.getAttribute("user");

        // Check if the logged-in user matches the edited profile
        Profile user = profileRepository.findById(sessionUser.getId()).orElse(null);

        if (user != null && user.getId() == sessionUser.getId()) {

            // Update the user entity with the updated profile fields
            if (bindingResult.hasErrors()) {
                // If there are validation errors, add them to the model
                model.addAttribute("validationErrors", bindingResult.getAllErrors());
            } else {
                // Update the user entity with new profile information if the fields are not blank
                if (profile.getUsername() != null && !profile.getUsername().isEmpty()) {
                    user.setUsername(profile.getUsername());
                }
                // Update the profile with the new email
                if (profile.getEmail() != null && !profile.getEmail().isEmpty()) {
                    user.setEmail(profile.getEmail());
                }
                if (profile.getPwHash() != null && !profile.getPwHash().isEmpty()) {
                    String passwordHash = encoder.encode(profile.getPwHash());
                    user.setPwHash(passwordHash);
                }

            }

            // Save the updated profile to the UserRepository
            profileRepository.save(user);

            session.setAttribute("user", profile);

            return "redirect:/profile"; // Redirect back to the profile page
        }
        return "redirect:/edit-profile";
    }
}
