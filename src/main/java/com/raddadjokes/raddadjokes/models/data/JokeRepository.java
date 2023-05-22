package com.raddadjokes.raddadjokes.models.data;

import com.raddadjokes.raddadjokes.models.JokeModel;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event;

import java.util.List;

@Repository
public interface JokeRepository extends CrudRepository<JokeModel, Integer> {

    List<JokeModel> getAllJokes();

    void addJoke(JokeModel joke);

    JokeModel getJokeById(int id);

    void deleteJokeById(int id);
}
