package com.raddadjokes.raddadjokes;

import com.raddadjokes.raddadjokes.data.JokeRepository;
import com.raddadjokes.raddadjokes.models.Joke;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
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

    private ArrayList<String> dirtyWords = new ArrayList<>(Arrays.asList("4r5e", "5h1t", "5hit", "a55", "anal", "anus", "ar5e", "arrse", "arse", "ass", "ass-fucker", "asses", "assfucker", "assfukka", "asshole", "assholes", "asswhole", "a_s_s", "b!tch", "b00bs", "b17ch", "b1tch", "ballbag", "balls", "ballsack", "bastard", "beastial", "beastiality", "bellend", "bestial", "bestiality", "bi+ch", "biatch", "bitch", "bitcher", "bitchers", "bitches", "bitchin", "bitching", "bloody", "blow job", "blowjob", "blowjobs", "boiolas", "bollock", "bollok", "boner", "boob", "boobs", "booobs", "boooobs", "booooobs", "booooooobs", "breasts", "buceta", "bugger", "bum", "bunny fucker", "butt", "butthole", "buttmuch", "buttplug", "c0ck", "c0cksucker", "carpet muncher", "cawk", "chink", "cipa", "cl1t", "clit", "clitoris", "clits", "cnut", "cock", "cock-sucker", "cockface", "cockhead", "cockmunch", "cockmuncher", "cocks", "cocksuck", "cocksucked", "cocksucker", "cocksucking", "cocksucks", "cocksuka", "cocksukka", "cok", "cokmuncher", "coksucka", "coon", "cox", "crap", "cum", "cummer", "cumming", "cums", "cumshot", "cunilingus", "cunillingus", "cunnilingus", "cunt", "cuntlick", "cuntlicker", "cuntlicking", "cunts", "cyalis", "cyberfuc", "cyberfuck", "cyberfucked", "cyberfucker", "cyberfuckers", "cyberfucking", "d1ck", "damn", "dick", "dickhead", "dildo", "dildos", "dink", "dinks", "dirsa", "dlck", "dog-fucker", "doggin", "dogging", "donkeyribber", "doosh", "duche", "dyke", "ejaculate", "ejaculated", "ejaculates", "ejaculating", "ejaculatings", "ejaculation", "ejakulate", "f u c k", "f u c k e r", "f4nny", "fag", "fagging", "faggitt", "faggot", "faggs", "fagot", "fagots", "fags", "fanny", "fannyflaps", "fannyfucker", "fanyy", "fatass", "fcuk", "fcuker", "fcuking", "feck", "fecker", "felching", "fellate", "fellatio", "fingerfuck", "fingerfucked", "fingerfucker", "fingerfuckers", "fingerfucking", "fingerfucks", "fistfuck", "fistfucked", "fistfucker", "fistfuckers", "fistfucking", "fistfuckings", "fistfucks", "flange", "fook", "fooker", "fuck", "fucka", "fucked", "fucker", "fuckers", "fuckhead", "fuckheads", "fuckin", "fucking", "fuckings", "fuckingshitmotherfucker", "fuckme", "fucks", "fuckwhit", "fuckwit", "fudge packer", "fudgepacker", "fuk", "fuker", "fukker", "fukkin", "fuks", "fukwhit", "fukwit", "fux", "fux0r", "f_u_c_k", "gangbang", "gangbanged", "gangbangs", "gaylord", "gaysex", "goatse", "God", "god-dam", "god-damned", "goddamn", "goddamned", "hardcoresex", "hell", "heshe", "hoar", "hoare", "hoer", "homo", "hore", "horniest", "horny", "hotsex", "jack-off", "jackoff", "jap", "jerk-off", "jism", "jiz", "jizm", "jizz", "kawk", "knob", "knobead", "knobed", "knobend", "knobhead", "knobjocky", "knobjokey", "kock", "kondum", "kondums", "kum", "kummer", "kumming", "kums", "kunilingus", "l3i+ch", "l3itch", "labia", "lust", "lusting", "m0f0", "m0fo", "m45terbate", "ma5terb8", "ma5terbate", "masochist", "master-bate", "masterb8", "masterbat*", "masterbat3", "masterbate", "masterbation", "masterbations", "masturbate", "mo-fo", "mof0", "mofo", "mothafuck", "mothafucka", "mothafuckas", "mothafuckaz", "mothafucked", "mothafucker", "mothafuckers", "mothafuckin", "mothafucking", "mothafuckings", "mothafucks", "mother fucker", "motherfuck", "motherfucked", "motherfucker", "motherfuckers", "motherfuckin", "motherfucking", "motherfuckings", "motherfuckka", "motherfucks", "muff", "mutha", "muthafecker", "muthafuckker", "muther", "mutherfucker", "n1gga", "n1gger", "nazi", "nigg3r", "nigg4h", "nigga", "niggah", "niggas", "niggaz", "nigger", "niggers", "nob", "nob jokey", "nobhead", "nobjocky", "nobjokey", "numbnuts", "nutsack", "orgasim", "orgasims", "orgasm", "orgasms", "p0rn", "pawn", "pecker", "penis", "penisfucker", "phonesex", "phuck", "phuk", "phuked", "phuking", "phukked", "phukking", "phuks", "phuq", "pigfucker", "pimpis", "piss", "pissed", "pisser", "pissers", "pisses", "pissflaps", "pissin", "pissing", "pissoff", "poop", "porn", "porno", "pornography", "pornos", "prick", "pricks", "pron", "pube", "pusse", "pussi", "pussies", "pussy", "pussys", "rectum", "retard", "rimjaw", "rimming", "s hit", "s.o.b.", "sadist", "schlong", "screwing", "scroat", "scrote", "scrotum", "semen", "sex", "sh!+", "sh!t", "sh1t", "shag", "shagger", "shaggin", "shagging", "shemale", "shi+", "shit", "shitdick", "shite", "shited", "shitey", "shitfuck", "shitfull", "shithead", "shiting", "shitings", "shits", "shitted", "shitter", "shitters", "shitting", "shittings", "shitty", "skank", "slut", "sluts", "smegma", "smut", "snatch", "son-of-a-bitch", "spac", "spunk", "s_h_i_t", "t1tt1e5", "t1tties", "teets", "teez", "testical", "testicle", "tit", "titfuck", "tits", "titt", "tittie5", "tittiefucker", "titties", "tittyfuck", "tittywank", "titwank", "tosser", "turd", "tw4t", "twat", "twathead", "twatty", "twunt", "twunter", "v14gra", "v1gra", "vagina", "viagra", "vulva", "w00se", "wang", "wank", "wanker", "wanky", "whoar", "whore", "willies", "willy", "xrated", "xxx"));


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
            String setup = apiJoke.getSetup();
            String punchline = apiJoke.getPunchline();
            System.out.println("****" + setup);
            System.out.println("****" + punchline);

            // Check if the joke contains any dirty words in the setup or punchline
            boolean containsDirtyWords = false;
            for (String dirtyWord : dirtyWords) {
                if (setup.toLowerCase().contains(dirtyWord.toLowerCase()) || punchline.toLowerCase().contains(dirtyWord.toLowerCase())) {
                    containsDirtyWords = true;
                    break;
                }
            }

            // Save the joke only if it does not contain any dirty words and is not already in the database
            if (!containsDirtyWords && apiJoke != null && !apiJoke.getNsfw()) {
                Optional<Joke> jokeCheck = Optional.ofNullable(jokeRepository.findJokeByApiId(apiId));
                if (jokeCheck.isEmpty()) {
                    jokeRepository.save(apiJoke);
                }
            }
        }
    }
}


