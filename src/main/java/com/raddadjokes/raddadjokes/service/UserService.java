package com.raddadjokes.raddadjokes.service;

import com.raddadjokes.raddadjokes.models.User;
import com.raddadjokes.raddadjokes.web.dto.UserRegistrationDto;
//import org.springframework.boot.autoconfigure.security.SecurityProperties;

public interface UserService {
    User save(UserRegistrationDto registrationDto);
}
