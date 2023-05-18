package com.raddadjokes.raddadjokes.models.data;

import com.raddadjokes.raddadjokes.models.JokeModel;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JokeRepository extends CrudRepository<JokeModel, Integer> {

}
