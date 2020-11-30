package com.penguinjournals.laboratory.domain;

import java.time.LocalDate;

public class Prediction {
    private Integer id;
    private String title;
    private String body;
    private LocalDate deadline;

    public Integer getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getBody() {
        return this.body;
    }

    public LocalDate getDeadline() {
        return this.deadline;
    }
}
