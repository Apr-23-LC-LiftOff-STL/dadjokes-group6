package com.raddadjokes.raddadjokes;

import com.raddadjokes.raddadjokes.data.JokeRepository;
import com.raddadjokes.raddadjokes.models.Joke;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class RadDadJokesApplication implements CommandLineRunner {
	private final JokeFetcher jokeFetcher;
	private final JokeRepository jokeRepository;

	@Autowired
	public RadDadJokesApplication(JokeFetcher jokeFetcher, JokeRepository jokeRepository) {
		this.jokeFetcher = jokeFetcher;
		this.jokeRepository = jokeRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(RadDadJokesApplication.class, args);
	}


	@Override
	public void run(String... args) {
//PLEASE COMMENT THIS METHOD OUT WHEN NOT TESTING THE API

		// When the application runs, call dadjokes.io API
		String jokeJson = jokeFetcher.fetchData();
		System.out.println("***STRING RETURNED FROM API*** " + jokeJson);

		// Parses the http string into a list of jokes
		List<Joke> apiJokes = jokeFetcher.parseJsonToJokes(jokeJson);
		System.out.println("***PARSED API JOKES*** " + apiJokes.toString());

		// Saves the apiJokes to the database
		jokeFetcher.saveApiJokes(apiJokes);
	}
}