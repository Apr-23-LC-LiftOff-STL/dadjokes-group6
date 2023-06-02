package com.raddadjokes.raddadjokes.SignUpController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class SignUpController {

    @GetMapping("user/signup") //may need a new name
    public String showSignUpForm(WebRequest request, Model model);
        UserDto userDTO = new UserDTO();
        model.addAttribute("user", userDto);
        return "registration";
}
