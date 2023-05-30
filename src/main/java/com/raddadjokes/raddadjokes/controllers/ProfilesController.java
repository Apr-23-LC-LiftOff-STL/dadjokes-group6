package com.raddadjokes.raddadjokes.controllers;

import com.raddadjokes.raddadjokes.data.ProfilesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class ProfilesController {

    @Autowired
    private ProfilesRepository profilesRepository;

}
