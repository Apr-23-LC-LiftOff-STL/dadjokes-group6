package com.raddadjokes.raddadjokes.controllers;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


import com.raddadjokes.raddadjokes.Profile;
import com.raddadjokes.raddadjokes.data.ProfilesRepository;
import com.raddadjokes.raddadjokes.models.Profiles;
import com.raddadjokes.raddadjokes.models.data.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private ProfilesRepository userRepository;

    private static Map<String, Profiles> sessionStore = new HashMap<>();

    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpSession session) {
        // Perform authentication logic
        boolean authenticated = authenticateUser(username, password);

        if (authenticated) {
            Profiles user = userRepository.findByUsername(username);
            String sessionId = generateSessionId(user);
            session.setAttribute("sessionId", sessionId);
            // ...
            return "redirect:/index";
        } else {
            // ...
            return "redirect:/login";
        }
    }

    public boolean authenticateUser(String username, String password) {
        // Retrieve the user by username from the UserRepository
        Profiles user = userRepository.findByUsername(username);

        // Check if the user exists and the provided password matches
        return user != null && user.isMatchingPassword(password);

    }

    public static String generateSessionId(Profiles user) {
        // Generate a random UUID (Universally Unique Identifier)
        UUID uuid = UUID.randomUUID();

        // Remove hyphens from the UUID string
        String sessionId = uuid.toString().replace("-", "");

        sessionStore.put(sessionId, user);

        return sessionId;
    }



    // Other controller methods
}
