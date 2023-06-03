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
@RequestMapping("/sign-in")
public class SignInController {

    @Autowired
    private ProfilesRepository profileRepository;

    @GetMapping
    public String showSignIn(Model model, HttpSession session) {

        return "/sign-in";
    }
}