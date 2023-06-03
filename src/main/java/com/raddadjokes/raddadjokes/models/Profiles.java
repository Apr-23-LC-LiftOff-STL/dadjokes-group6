package com.raddadjokes.raddadjokes.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Table(name = "profiles")
@Entity
public class Profiles {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Integer user_id;

    @NotBlank(message = "A username is required.")
    @Size(min = 3, max = 20, message = "Your username must be between 3 and 20 characters.")
    private String username;

    @NotBlank(message = "A password is required.")
    @Size(min = 1, max = 20, message = "Your password must be between 8 and 20 characters.")
    @Column(name = "user_Password")
    private String pwHash;

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    public boolean isMatchingPassword(String password) {
        return encoder.matches(password, pwHash);
    }

    @NotBlank(message = "An email address is required.")
    @Size(min = 5, max = 40, message = "Your email address must be between 8 and 40 characters.")
    private String email;

    public Profiles() {}
    public Profiles(String username, String pwHash, String email) {
        this();
        this.username = username;
        this.pwHash = encoder.encode(pwHash);
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwHash() {
        return pwHash;
    }

    public void setPwHash(String pwHash) {
        this.pwHash = pwHash;
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
        if (!(o instanceof Profiles)) return false;
        if (!super.equals(o)) return false;
        Profiles users = (Profiles) o;
        return getUsername().equals(users.getUsername()) && getPwHash().equals(users.getPwHash()) && getEmail().equals(users.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getUsername(), getPwHash(), getEmail());
    }

    @Override
    public String toString() {
        return "Profiles{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}