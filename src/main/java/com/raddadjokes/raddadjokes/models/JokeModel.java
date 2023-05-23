package com.raddadjokes.raddadjokes.models;

import com.raddadjokes.raddadjokes.AbstractEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Entity;

@Entity
public class JokeModel extends AbstractEntity {
    public JokeModel() {

    }

    private static String setup;
    private static String punchline;

    public String JokeInput(String setup, String punchline) {
        this.setup = setup;
        this.punchline = punchline;
        return setup + "|" + punchline;
        //to return use return_value.split("|") gives array of values
    }

    public static String getSetup() {
        return setup;
    }

    public Object setSetup(String setup) {
        this.setup = setup;
        return null;
    }

    public static String getPunchline() {
        return punchline;
    }

    public Object setPunchline(String punchline) {
        this.punchline = punchline;
        return null;
    }
}
