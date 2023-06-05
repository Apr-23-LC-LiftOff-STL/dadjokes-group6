package com.raddadjokes.raddadjokes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.raddadjokes.raddadjokes.data.ProfilesRepository;
import com.raddadjokes.raddadjokes.models.Profiles;


@Controller
public class LogoutController {

//copied from the Josh's lOGIN controller as reference
    @Autowired
    private ProfilesRepository userRepository;

    private static Map<String, Profiles> sessionStore = new HashMap<>();

    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpSession session) {
        // Perform authentication logic
        String sessionId = authenticateUserAndGenerateSessionId(username, password);

        if (sessionId != null) {
            session.setAttribute("sessionId", sessionId);
            // ...
            return "redirect:/index";
        } else {
            // ...
            return "redirect:/login";
        }
    }

    public String authenticateUserAndGenerateSessionId(String username, String password) {
        // Retrieve the user by username from the UserRepository
        Profiles user = userRepository.findById(username);

        // Check if the user exists and the provided password matches
        if (user != null && user.isMatchingPassword(password)) {
            return generateSessionId(user);
        }

        return null;
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

