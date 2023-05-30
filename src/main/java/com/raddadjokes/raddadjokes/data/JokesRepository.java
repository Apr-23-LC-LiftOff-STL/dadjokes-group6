package com.raddadjokes.raddadjokes.data;

import com.raddadjokes.raddadjokes.models.Jokes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JokesRepository extends CrudRepository<Jokes, Integer> {
}
