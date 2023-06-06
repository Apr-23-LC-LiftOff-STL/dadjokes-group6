package com.raddadjokes.raddadjokes;

//import com.raddadjokes.raddadjokes.models.Jokes;
import com.raddadjokes.raddadjokes.models.Joke;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;




@SpringBootApplication
public class RadDadJokesApplication {

	public static void main(String[] args) {

		JokeFetcher jokeFetcher = new JokeFetcher();
		String jokeJson = jokeFetcher.fetchData();
		System.out.println(jokeJson);
//		System.out.println(jokeJson.getClass());
		Joke apiJoke = jokeFetcher.parseJsonToJokes(jokeJson);
		System.out.println(apiJoke.toString());
		SpringApplication.run(RadDadJokesApplication.class, args);
	}

}
