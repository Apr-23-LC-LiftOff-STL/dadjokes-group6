package com.raddadjokes.raddadjokes.models.data;

import com.raddadjokes.raddadjokes.models.JokeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JokeRepository extends CrudRepository<JokeModel.Joke, Integer> {
    
}
