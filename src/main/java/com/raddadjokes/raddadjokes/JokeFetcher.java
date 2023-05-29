package com.raddadjokes.raddadjokes;

import models.Jokes;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;
import java.net.HttpURLConnection;
import java.net.URL;

public class JokeFetcher {
    public String fetchData() {
        try {
            //DadJokes.io API endpoint - add ?count=5 to end of URL to return the maximum amount of jokes per request
            URL url = new URL("https://dad-jokes.p.rapidapi.com/random/joke");

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

    public static Jokes parseJsonToJokes(String jsonString){
        try{
            //Parse JSON String
            JSONObject jsonObject = new JSONObject(jsonString);

            //Extract body Array
            JSONArray bodyArray = jsonObject.getJSONArray("body");

            //Checks if the bodyArray is empty
            if (bodyArray.length() > 0) {

                //Get the first/only object in bodyArray
                JSONObject jokeObject = bodyArray.getJSONObject(0);

                //Sets the instance of user_id to be the value associated with DadJokes.io profile
                Integer user_id = 1;

                //extracts values from keys in bodyArray
                String setup = jokeObject.getString("setup");
                String punchline = jokeObject.getString("punchline");
                String api_id = jokeObject.getString("_id");
                Boolean nsfw = jokeObject.getBoolean("NSFW");

                //creates a new Joke with the returned values
                Jokes apiJoke = new Jokes(user_id, setup, punchline, api_id, nsfw);

                //returns a Joke object with the values from the API call to DadJokes.io
                return apiJoke;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}


