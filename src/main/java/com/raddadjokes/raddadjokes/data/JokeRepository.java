package com.raddadjokes.raddadjokes.data;

import com.raddadjokes.raddadjokes.models.Joke;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JokeRepository extends JpaRepository<Joke, Integer> {

    Joke findJokeBySetup(String setup);
    Joke findJokeByPunchline(String punchline);
    Joke findJokeByApiId(String apiId);
    Joke findJokeByUserId(Long userId);

}