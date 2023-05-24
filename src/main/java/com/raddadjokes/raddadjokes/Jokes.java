package com.raddadjokes.raddadjokes;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;
import com.raddadjokes.raddadjokes.AbstractEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Table(name = "jokes")
@Entity
public class Jokes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Integer joke_id;

    @NotBlank(message = "The joke field cannot be blank.")
    @Size(min = 10, max = 4000, message = "The joke must be between 10 and 4000 characters.")
    private String setup;

    @Size(max = 20, message = "Your password must be between 8 and 20 characters.")
    private String punchline;

    private String api_id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private Integer user_id;

    public Jokes() {}

    public Jokes(String setup, String punchline) {
        this.setup = setup;
        this.punchline = punchline;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Jokes)) return false;
        Jokes jokes = (Jokes) o;
        return getJoke_id().equals(jokes.getJoke_id()) && getSetup().equals(jokes.getSetup()) && Objects.equals(getPunchline(), jokes.getPunchline()) && Objects.equals(getApi_id(), jokes.getApi_id());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getJoke_id(), getSetup(), getPunchline(), getApi_id());
    }

    @Override
    public String toString() {
        return "Jokes{" +
                "setup='" + setup + '\'' +
                ", punchline='" + punchline + '\'' +
                '}';
    }
}
