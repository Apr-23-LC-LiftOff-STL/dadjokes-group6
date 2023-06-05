package com.raddadjokes.raddadjokes.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Collection;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_name", unique = true)
    @Size(min=4, max=25, message = "Username must be between 4 and 25 characters.")
    private String userName;
    @Column(name = "email", unique = true)
    @NotBlank
    private String email;
    @Column(name = "password")
    @Size(min =4, max=50, message = "Password must be between 4 and 25 characters.")
    private String password;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name="user_jokes",
            joinColumns = @JoinColumn(
            name="user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name="joke_id", referencedColumnName = "id"
            )

    )
    private Collection<Joke> userJokes;

//    NON-MVP Fields:
//    @Column(name = "first_name")
//    private String firstName;
//    @Column(name = "last_name")
//    private String lastName;
//    @Column(name = "saved_jokes")
//    private Collection<Joke> savedJokes;
//    private String passwordConfirm;
//    @Column(name = "flagged_jokes")
//    private Collection<Joke> flaggedJokes;
//    @Column(name = "liked_jokes")
//    private Collection<Joke> radJokes;
//    @Column(name = "disliked_jokes")
//    private Collection<Joke> badJokes;


    public User(){}
    public User(String userName, String email, String password, Collection<Joke> userJokes) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.userJokes = userJokes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Joke> getUserJokes() {
        return userJokes;
    }

    public void setUserJokes(Collection<Joke> userJokes) {
        this.userJokes = userJokes;
    }
}