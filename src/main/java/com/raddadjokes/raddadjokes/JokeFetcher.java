package com.raddadjokes.raddadjokes;

import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
//import java.net.MalformedURLException;
import java.net.URL;

public class JokeFetcher {
    public JSONObject fetchData() {
        try {
            URL url = new URL("https://dad-jokes.p.rapidapi.com/random/joke");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("X-RapidAPI-Key", "4fa023a5damshaf3fd7a83ec407ep121da3jsn169b40d856e9");
            connection.setRequestProperty("X-RapidAPI-Host", "dad-jokes.p.rapidapi.com");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                String jsonString = new String(connection.getInputStream().readAllBytes());
                JSONObject json = new JSONObject(jsonString);
                return json;
            } else {
                System.out.println("Request failed. Response Code: " + responseCode);
            }
//        } catch (MalformedURLException e) {
//            e.printStackTrace(); // Handle or log the exception as per your requirement
//        } catch (IOException e) {
//            e.printStackTrace(); // Handle or log the exception
        } catch (Exception e) {
            e.printStackTrace();
        }


            return null;
    }
//
//    public static String parseJsonToString(String jsonString){
//
//    }
}


