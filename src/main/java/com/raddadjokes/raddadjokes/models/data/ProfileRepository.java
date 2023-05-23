package com.raddadjokes.raddadjokes.models.data;

import com.raddadjokes.raddadjokes.Profile;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<Profile, Integer> {

    Profile findByUsername(String username);

}
