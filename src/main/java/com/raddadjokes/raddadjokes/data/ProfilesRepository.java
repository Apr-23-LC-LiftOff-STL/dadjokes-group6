package com.raddadjokes.raddadjokes.data;

import com.raddadjokes.raddadjokes.models.Profiles;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfilesRepository extends CrudRepository<Profiles, Integer> {

    Profiles findById(String username);

}
