package com.raddadjokes.raddadjokes;

import com.raddadjokes.raddadjokes.data.JokeRepository;
import com.raddadjokes.raddadjokes.models.Joke;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
//import java.util.Optional;

@Component
public class JokeFetcher {


    @Autowired
    private JokeRepository jokeRepository;

//    @Autowired
//    public JokeFetcher(JokeRepository jokeRepository){
//        this.jokeRepository = jokeRepository;
//    }

//    private Optional<Joke> jokeCheck;

//    public JokeFetcher(){}


    public String fetchData() {
        try {
            //DadJokes.io API endpoint - add ?count=5 to end of URL to return the maximum amount of jokes per request
            URL url = new URL("https://dad-jokes.p.rapidapi.com/random/joke?count=5");

            //calls API
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("X-RapidAPI-Key", "4fa023a5damshaf3fd7a83ec407ep121da3jsn169b40d856e9");
            connection.setRequestProperty("X-RapidAPI-Host", "dad-jokes.p.rapidapi.com");

            //checks if the response is OK
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                String jsonString = new String(connection.getInputStream().readAllBytes());
                return jsonString;
            } else {
                System.out.println("Request failed. Response Code: " + responseCode);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }

    public List<Joke> parseJsonToJokes(String jsonString) {
        try {
            // Parse JSON String
            JSONObject jsonObject = new JSONObject(jsonString);

            // Extract body Array
            JSONArray bodyArray = jsonObject.getJSONArray("body");

            List<Joke> jokes = new ArrayList<>();

            // Iterate over each joke object in the bodyArray
            for (int i = 0; i < bodyArray.length(); i++) {
                JSONObject jokeObject = bodyArray.getJSONObject(i);

                // Extract joke details from jokeObject
                String setup = jokeObject.getString("setup");
                String punchline = jokeObject.getString("punchline");
                String apiId = jokeObject.getString("_id");
                Boolean nsfw = jokeObject.getBoolean("NSFW");

                // Create a new Joke object and set its values
                Joke apiJoke = new Joke();
                apiJoke.setUserId(13);
                apiJoke.setSetup(setup);
                apiJoke.setPunchline(punchline);
                apiJoke.setApiId(apiId);
                apiJoke.setNsfw(nsfw);

                // Add the joke to the list of jokes
                jokes.add(apiJoke);
            }

            // Return the list of jokes
            return jokes;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public void saveApiJokes(List<Joke> apiJokes) {
        for (Joke apiJoke : apiJokes) {
            String apiId = apiJoke.getApiId();
            if (apiJoke != null && !apiJoke.getNsfw()) {
                Optional<Joke> jokeCheck = Optional.ofNullable(jokeRepository.findJokeByApiId(apiId));
                if (jokeCheck.isEmpty()) {
                    jokeRepository.save(apiJoke);
                }
            }
        }
    }

}


