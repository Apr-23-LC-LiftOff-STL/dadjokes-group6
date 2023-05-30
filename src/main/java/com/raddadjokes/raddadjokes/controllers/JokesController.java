package com.raddadjokes.raddadjokes.controllers;

import com.raddadjokes.raddadjokes.data.JokesRepository;
import com.raddadjokes.raddadjokes.data.ProfilesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//might want to refactor the front end to be set up as pages instead of tabs, so we can use @RequestMapping like we did in the coding events demo
@Controller
@RequestMapping
public class JokesController {

    @Autowired
    private JokesRepository jokesRepository;

    @Autowired
    private ProfilesRepository profilesRepository;

}
