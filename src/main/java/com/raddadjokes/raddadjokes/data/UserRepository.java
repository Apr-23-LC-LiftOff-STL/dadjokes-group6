package com.raddadjokes.raddadjokes.data;

import com.raddadjokes.raddadjokes.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmail(String email);

    User findByUsername(String username);

    String findUsernameById(Integer id);

//    User findById(Integer id);

//    Collection findUserJokesByUserId(Integer userJokes);

}
