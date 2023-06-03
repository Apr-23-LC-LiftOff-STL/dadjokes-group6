package com.raddadjokes.raddadjokes.data;

import com.raddadjokes.raddadjokes.models.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends CrudRepository<Profile, Integer> {

    Profile findByUsername(String username);
}
