package com.raddadjokes.raddadjokes.controllers;

import com.raddadjokes.raddadjokes.data.ProfilesRepository;
import com.raddadjokes.raddadjokes.models.Profiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class AuthenticationController {

    @Autowired
    ProfilesRepository profilesRepository;

// copied and edited from
// https://education.launchcode.org/java-web-development/chapters/auth/login-registration-forms.html
private static final String userSessionKey = "userProfile";

    public Profiles getUserFromSession(HttpSession session) {
        Integer userId = (Integer) session.getAttribute(userSessionKey);
        if (userId == null) {
            return null;
        }
        Optional<Profiles> user = profilesRepository.findById(userId);
        if (user.isEmpty()) {
            return null;
        }
        return user.get();
    }

    private static void setUserInSession(HttpSession session, Profiles user) {
        session.setAttribute(userSessionKey, user.getUsername());
    }

}
