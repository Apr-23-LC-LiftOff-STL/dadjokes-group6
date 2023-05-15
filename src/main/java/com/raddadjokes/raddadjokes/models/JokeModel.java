package com.raddadjokes.raddadjokes.models;

public class JokeModel {
    public static class JokeInput {
        private String setup;
        private String punchline;

        public JokeInput() {}

        public JokeInput(String setup, String punchline) {
            this.setup = setup;
            this.punchline = punchline;
        }

        public String getSetup() {
            return setup;
        }

        public void setSetup(String setup) {
            this.setup = setup;
        }

        public String getPunchline() {
            return punchline;
        }

        public void setPunchline(String punchline) {
            this.punchline = punchline;
        }
    }
    public static class Joke {
        private int id;
        private String setup;
        private String punchline;

        public Joke() {}

        public Joke(int id, String setup, String punchline) {
            this.id = id;
            this.setup = setup;
            this.punchline = punchline;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getSetup() {
            return setup;
        }

        public void setSetup(String setup) {
            this.setup = setup;
        }

        public String getPunchline() {
            return punchline;
        }

        public void setPunchline(String punchline) {
            this.punchline = punchline;
        }
    }

}
