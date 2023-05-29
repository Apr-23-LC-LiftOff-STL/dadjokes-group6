package com.raddadjokes.raddadjokes;

import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;




@SpringBootApplication
public class RadDadJokesApplication {

	public static void main(String[] args) {

		SpringApplication.run(RadDadJokesApplication.class, args);
		JokeFetcher jokeFetcher = new JokeFetcher();
		JSONObject jokeJson = jokeFetcher.fetchData();
		System.out.println(jokeJson);
	}

}
