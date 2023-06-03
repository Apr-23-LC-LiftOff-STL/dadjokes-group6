package com.raddadjokes.raddadjokes.data;

import com.raddadjokes.raddadjokes.models.Joke;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JokeRepository extends CrudRepository<Joke, Integer> {
}
