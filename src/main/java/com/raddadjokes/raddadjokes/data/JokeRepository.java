package com.raddadjokes.raddadjokes.data;

import com.raddadjokes.raddadjokes.models.Joke;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface JokeRepository extends JpaRepository<Joke, Integer> {

    @Query("SELECT j.id FROM Joke j WHERE user_id = :user_Id")
    Collection<Long> findJokeIdsByUserId(@Param("user_Id") Long userId);

    //List<Joke> findAllByUserJokesUserId(Long userId);

    Joke findJokeBySetup(String setup);
    Joke findJokeByPunchline(String punchline);

    Joke findJokeById(Long id);
    Joke findJokeByApiId(String apiId);
    Joke findJokeByUserId(Long userId);
//    Joke findJokeIdByUserId(Long userId);

}