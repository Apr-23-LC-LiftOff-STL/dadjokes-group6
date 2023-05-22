package com.raddadjokes.raddadjokes.models.data;

import com.raddadjokes.raddadjokes.models.JokeModel;
import com.raddadjokes.raddadjokes.models.data.JokeRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class JokeRepositoryImplementation implements JokeRepository {

    private List<JokeModel> jokes;

    public JokeRepositoryImplementation() {
        this.jokes = new ArrayList<>();
    }

    @Override
    public List<JokeModel> getAllJokes() {
        return jokes;
    }

    @Override
    public void addJoke(JokeModel joke) {
        jokes.add(joke);
    }

    @Override
    public JokeModel getJokeById(int id) {
        for (JokeModel joke : jokes) {
            if (joke.getId() == id) {
                return joke;
            }
        }
        return null;
    }

    @Override
    public void deleteJokeById(int id) {
        JokeModel jokeToRemove = null;
        for (JokeModel joke : jokes) {
            if (joke.getId() == id) {
                jokeToRemove = joke;
                break;
            }
        }
        if (jokeToRemove != null) {
            jokes.remove(jokeToRemove);
        }
    }

    @Override
    public <S extends JokeModel> S save(S entity) {
        return null;
    }

    @Override
    public <S extends JokeModel> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<JokeModel> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public Iterable<JokeModel> findAll() {
        return null;
    }

    @Override
    public Iterable<JokeModel> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(JokeModel entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends JokeModel> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
