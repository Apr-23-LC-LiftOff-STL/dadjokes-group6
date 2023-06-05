package com.raddadjokes.raddadjokes.service;

import com.raddadjokes.raddadjokes.data.UserRepository;
import com.raddadjokes.raddadjokes.models.Joke;
import com.raddadjokes.raddadjokes.models.User;
import com.raddadjokes.raddadjokes.web.dto.UserRegistrationDto;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService {

//    @Autowired
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

//    update getPassword() to use Spring Security
//    not sure about the array USER_JOKES
//    STRETCH Features will require updating the save method
    @Override
    public User save(UserRegistrationDto registrationDto){
        User user = new User(registrationDto.getUserName(), registrationDto.getEmail(), registrationDto.getPassword(), Arrays.asList(new Joke()));

        return userRepository.save(user);
    }
}
