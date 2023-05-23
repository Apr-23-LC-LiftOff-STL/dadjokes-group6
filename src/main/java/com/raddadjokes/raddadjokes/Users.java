package com.raddadjokes.raddadjokes;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Integer user_id;

    @NotBlank(message = "A username is required.")
    @Size(min = 3, max = 20, message = "Your username must be between 3 and 20 characters.")
    private String username;

    @NotBlank(message = "A password is required.")
    @Size(min = 8, max = 20, message = "Your password must be between 8 and 20 characters.")
    private String user_password;

    @NotBlank(message = "An email address is required.")
    @Size(min = 8, max = 20, message = "Your email address must be between 8 and 40 characters.")
    private String email;

    public Users() {}

    public Users(String username, String user_password, String email) {
        this.username = username;
        this.user_password = user_password;
        this.email = email;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Users)) return false;
        Users users = (Users) o;
        return Objects.equals(getUser_id(), users.getUser_id()) && Objects.equals(getUsername(), users.getUsername()) && Objects.equals(getUser_password(), users.getUser_password()) && Objects.equals(getEmail(), users.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUser_id(), getUsername(), getUser_password(), getEmail());
    }

    @Override
    public String toString() {
        return "Profiles{" +
                "user_id=" + user_id +
                ", username='" + username + '\'' +
                ", user_password='" + user_password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
