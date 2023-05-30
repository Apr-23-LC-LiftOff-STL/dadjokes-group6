package com.raddadjokes.raddadjokes.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;


@Table(name = "jokes")
@Entity
public class Jokes extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false, name = "joke_id")
    private Integer joke_id;

    @NotBlank(message = "The joke setup field cannot be blank.")
    @Size(min = 5, max = 4000, message = "The joke setup must be between 5 and 4000 characters.")
    @Column(nullable = false, name = "setup")
    private String setup;

    @Size(max = 4000, message = "The joke punchline must be less than 4000 characters.")
    @Column(nullable = true, name = "punchline")
    private String punchline;

    @Column(updatable = false, nullable = true, name = "api_id")
    private String api_id;

    //should this be a ManyToOne or OneToMany? One user_id can be associated with many jokes, right?
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private Integer user_id;

    private Boolean nsfw;


    public Jokes() {}

    public Jokes(String setup, String punchline) {
        this();
        this.setup = setup;
        this.punchline = punchline;
        //return setup + "|" + punchline;
        //to return use return_value.split("|") gives array of values
    }

    public Jokes(Integer user_id, String setup, String punchline, String api_id, Boolean nsfw) {
        this();
        this.user_id = user_id;
        this.setup = setup;
        this.punchline = punchline;
        this.api_id = api_id;
        this.nsfw = nsfw;
        //return setup + "|" + punchline;
        //to return use return_value.split("|") gives array of values
    }

    public Integer getJoke_id() {
        return joke_id;
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

    public String getApi_id() {
        return api_id;
    }

    public Boolean getNsfw() {
        return nsfw;
    }

    public void setNsfw(Boolean nsfw) {
        this.nsfw = nsfw;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Jokes)) return false;
        if (!super.equals(o)) return false;
        Jokes jokes = (Jokes) o;
        return getSetup().equals(jokes.getSetup()) && Objects.equals(getPunchline(), jokes.getPunchline()) && Objects.equals(getApi_id(), jokes.getApi_id()) && Objects.equals(user_id, jokes.user_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getSetup(), getPunchline(), getApi_id(), user_id, getNsfw());
    }

    @Override
    public String toString() {
        return  "Joke ID: " + joke_id + '\'' +
                "User ID: " + user_id + '\'' +
                "API ID: " + api_id + '\'' +
                "Setup: " + setup + '\'' +
                "Punchline: " + punchline + '\'' +
                "NSFW: " + nsfw;
    }
}