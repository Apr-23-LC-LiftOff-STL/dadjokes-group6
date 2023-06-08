package com.raddadjokes.raddadjokes.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Integer id;

    @Size(min=4, max=25, message = "Username must be between 4 and 25 characters.")
    @Column(name = "user_name", unique = true)
    private String username;

    @NotBlank
    @Column(name = "email", unique = true)
    private String email;
    //    @Size(min =4, max=100, message = "Password must be between 4 and 100 characters.")

    @NotBlank
    @Column(name = "password")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name="users_roles",
            joinColumns = @JoinColumn(
                    name="user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name="role_id", referencedColumnName = "id"
            )
    )
    private Collection<Role> roles;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinTable(
//            name="user_jokes",
//            joinColumns = @JoinColumn(
//                    name="user_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(
//                    name="joke_id", referencedColumnName = "id"
//            )
//    )
//    private Collection<Integer> userJokes;



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
    public User(String userName, String email, String password, Collection<Role> roles) {
        this.username = userName;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }
//    public User(String userName, String email, String password) {
//        this.userName = userName;
//        this.email = email;
//        this.password = password;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    public Collection<Integer> getUserJokes() {
        return userJokes;
    }

    public void setUserJokes(Collection<Integer> userJokes) {
        this.userJokes = userJokes;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                ", userJokes=" + userJokes +
                '}';
    }
}