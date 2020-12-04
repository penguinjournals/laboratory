package com.penguinjournals.laboratory.domain;

import java.util.List;

public class JwtResponse {
    private String token;
    private String type;
    private Long id;
    private String username;
    private String email;
    private List<String> roles;

    public JwtResponse(final String token,
                       final Long id,
                       final String username,
                       final String email,
                       final List<String> roles) {
        this.token = token;
        this.id = id;
        this.username = username;
        this.email = email;
        this.roles = roles;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(final String token) {
        this.token = token;
    }

    public String getType() {
        return this.type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public List<String> getRoles() {
        return this.roles;
    }

    public void setRoles(final List<String> roles) {
        this.roles = roles;
    }
}
