package com.raddadjokes.raddadjokes.models;

import com.raddadjokes.raddadjokes.AbstractEntity;

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
//    public static class Joke {
//        private int id;
//        private String setup;
//        private String punchline;
//
//        public Joke() {}
//
//        public Joke(int id, String setup, String punchline) {
//            this.id = id;
//            this.setup = setup;
//            this.punchline = punchline;
//        }
//
//        public Joke(String setup, String punchline) {
//
//        }
//
//
//        public int getId() {
//            return id;
//        }
//
//        public void setId(int id) {
//            this.id = id;
//        }
//
//        public String getSetup() {
//            return setup;
//        }
//
//        public void setSetup(String setup) {
//            this.setup = setup;
//        }
//
//        public String getPunchline() {
//            return punchline;
//        }
//
//        public void setPunchline(String punchline) {
//            this.punchline = punchline;
//        }
//    }

//}
