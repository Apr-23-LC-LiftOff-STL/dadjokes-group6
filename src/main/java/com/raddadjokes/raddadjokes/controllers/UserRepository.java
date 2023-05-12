package com.raddadjokes.raddadjokes.controllers;

import com.raddadjokes.raddadjokes.Profile;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Profile, Integer> {

    Profile findByUsername(String username);

}
