package com.raddadjokes.raddadjokes.config;

import com.raddadjokes.raddadjokes.models.data.JokeRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public JokeRepository jokeRepository() {
        // Create and return an instance of JokeRepository
        return new JokeRepository();
}
