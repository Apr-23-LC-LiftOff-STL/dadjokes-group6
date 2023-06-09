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
    Collection<Integer> findJokeIdsByUserId(@Param("user_Id") Integer userId);

    //List<Joke> findAllByUserJokesUserId(Long userId);

    Joke findJokeBySetup(String setup);
    Joke findJokeByPunchline(String punchline);

    Joke findJokeById(Integer id);
    Joke findJokeByApiId(String apiId);
    Collection<Joke> findJokeByUserId(Integer userId);

    Joke deleteById(Integer id);

}