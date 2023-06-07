package com.raddadjokes.raddadjokes.data;

import com.raddadjokes.raddadjokes.models.Joke;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface JokeRepository extends JpaRepository<Joke, Integer> {

    Joke findJokeBySetup(String setup);
    Joke findJokeByPunchline(String punchline);
    Joke findJokeByApiId(String apiId);
    Joke findJokeByUserId(Long userId);
    Joke findJokeIdByUserId(Long userId);
    @Query("SELECT j.id FROM Joke j WHERE j.user.id = :userId")
    Collection<Joke> findJokeIdsByUserId(@Param("userId") Long userId);
}