package com.raddadjokes.raddadjokes.controllers;

import com.raddadjokes.raddadjokes.data.UserRepository;
import com.raddadjokes.raddadjokes.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;



@Controller
@RequestMapping("/edit-profile")
public class EditProfileController {
    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @GetMapping
    public String showEditProfile(Model model, Authentication authentication) {

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String email = userDetails.getUsername();

        // Retrieve the profile from the repository based on the username
        User user = userRepository.findByEmail(email);


        // Add the profile to the model
        model.addAttribute("user", user);

        // Return the edit profile form view
        return "edit-profile";
    }


    @PostMapping("/profile/update")
    public String updateProfile(
            @Valid @ModelAttribute("user") User user,
            BindingResult bindingResult,
            Authentication authentication,
            Model model,
            HttpServletRequest request,
            @RequestParam(name = "newPassword", required = false) String newPassword,
            @RequestParam(name = "currentPassword") String currentPassword
    ) {

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String email = userDetails.getUsername();

        // Retrieve the profile from the repository based on the username
        User curUser = userRepository.findByEmail(email);


        if (!encoder.matches(currentPassword, curUser.getPassword())) {
            bindingResult.rejectValue("currentPassword", "error.user", "Current password is incorrect.");
        }

            // Update the user entity with the updated profile fields
            if (bindingResult.hasErrors()) {
                // If there are validation errors, add them to the model
                model.addAttribute("validationErrors", bindingResult.getAllErrors());
            } else {
                // Update the user entity with new profile information if the fields are not blank
                if (curUser.getUsername() != null && !curUser.getUsername().isEmpty()) {
                    curUser.setUsername(user.getUsername());
                }
                // Update the profile with the new email
                if (curUser.getEmail() != null && !curUser.getEmail().isEmpty()) {
                    curUser.setEmail(user.getEmail());
                }
                if (newPassword != null && !newPassword.isEmpty()) {
                    String passwordHash = encoder.encode(newPassword);
                    curUser.setPassword(passwordHash);
                }
                // Save the updated profile to the UserRepository
                userRepository.save(curUser);

                model.addAttribute("user", curUser);

                // Redirect back to the profile page
                request.getSession().invalidate();
                return "redirect:/login";
            }

        return "redirect:/edit-profile";
    }
}