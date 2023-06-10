package com.raddadjokes.raddadjokes.service;

import com.raddadjokes.raddadjokes.data.JokeRepository;
import com.raddadjokes.raddadjokes.data.UserRepository;
import com.raddadjokes.raddadjokes.models.Joke;
import com.raddadjokes.raddadjokes.models.User;
import com.raddadjokes.raddadjokes.web.dto.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.boot.autoconfigure.security.SecurityProperties;

public interface UserService extends UserDetailsService {

    User save(UserRegistrationDto registrationDto);


}
