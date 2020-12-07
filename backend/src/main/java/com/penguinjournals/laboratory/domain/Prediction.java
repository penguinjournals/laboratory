package com.penguinjournals.laboratory.domain;

import java.time.LocalDateTime;

public class Prediction {
    private Integer id;
    private String title;
    private String body;
    private LocalDateTime deadline;

    public Integer getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getBody() {
        return this.body;
    }

    public LocalDateTime getDeadline() {
        return this.deadline;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Prediction{");
        sb.append("id=").append(id);
        sb.append(", title='").append(title).append('\'');
        sb.append(", body='").append(body).append('\'');
        sb.append(", deadline=").append(deadline);
        sb.append('}');
        return sb.toString();
    }
}
