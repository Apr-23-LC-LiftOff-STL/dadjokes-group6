package com.raddadjokes.raddadjokes.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/edit-profile")
public class EditProfileController {


    @GetMapping
    public String showEditProfiles(Model model, HttpSession session) {

        return "/edit-profile";
    }
}