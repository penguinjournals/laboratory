package com.penguinjournals.laboratory.domain;

import java.util.List;

public class User {
    private Long id;
    private String name;
    private String email;
    private String password;
    private List<Role> roles;

    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return this.roles;
    }

    public void setRoles(final List<Role> roles) {
        this.roles = roles;
    }
}
