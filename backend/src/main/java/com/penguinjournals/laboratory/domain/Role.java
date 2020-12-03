package com.penguinjournals.laboratory.domain;

public class Role {
    private Long id;
    private RoleName name;

    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public RoleName getName() {
        return this.name;
    }

    public void setName(final RoleName name) {
        this.name = name;
    }
}
