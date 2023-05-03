package org.example;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class Profile extends AbstractEntity{
    @NotNull
    private String username;

    @NotNull
    private String email;

    @NotNull
    private String pwHash;

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public Profile() {}

    public Profile(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.pwHash = encoder.encode(password);
    }

    public String getUsername() {
        return username;
    }

    public boolean isMatchingPassword(String password) {
        return encoder.matches(password, pwHash);
    }

}
