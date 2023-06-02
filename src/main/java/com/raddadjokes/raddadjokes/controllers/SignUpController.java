package com.raddadjokes.raddadjokes.controllers;

import com.raddadjokes.raddadjokes.models.Profiles;
import com.raddadjokes.raddadjokes.data.ProfilesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.validation.Errors;

@Controller
@RequestMapping("/sign-up")
public class SignUpController {

    @Autowired
    private ProfilesRepository profileRepository;

    @GetMapping
    public String showSignUp(Model model, HttpSession session) {
        model.addAttribute(new Profiles());
        return "/sign-up";
    }

    @PostMapping
    public String processSignUpForm(@ModelAttribute @Valid Profiles newProfile,
                                    Errors errors, Model model){

        if(errors.hasErrors()) {
            return "sign-up";
        }
        profileRepository.save(newProfile);
        return ("redirect:/sign-in");
    }
}