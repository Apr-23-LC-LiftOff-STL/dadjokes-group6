package com.raddadjokes.raddadjokes;

import com.raddadjokes.raddadjokes.models.Jokes;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//reverted to pre-bean error.
//created development-mitchell branch

@SpringBootApplication
public class RadDadJokesApplication {

	public static void main(String[] args) {

		SpringApplication.run(RadDadJokesApplication.class, args);
		JokeFetcher jokeFetcher = new JokeFetcher();
		String jokeJson = jokeFetcher.fetchData();
		System.out.println(jokeJson);
//		System.out.println(jokeJson.getClass());
		Jokes apiJoke = jokeFetcher.parseJsonToJokes(jokeJson);
		System.out.println(apiJoke.toString());
	}

}
