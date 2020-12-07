package com.penguinjournals.laboratory.dao;

import com.penguinjournals.laboratory.domain.Prediction;
import com.penguinjournals.laboratory.domain.User;
import org.jooq.DSLContext;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.penguinjournals.laboratory.jooq.tables.Prediction.PREDICTION;

@Component
public class PredictionDao {
    private DSLContext dslContext;

    public PredictionDao(final DSLContext dslContext) {
        this.dslContext = dslContext;
    }

    public List<Prediction> getPredictionsSortedByDate() {
        return getDsl()
                .select()
                .from(PREDICTION)
                .orderBy(PREDICTION.DEADLINE.desc())
                .fetchInto(Prediction.class);
    }

    public void insertPredictionForUser(final Prediction prediction, final User user) {
        getDsl().insertInto(PREDICTION)
                .set(PREDICTION.USER_DATA_ID, user.getId())
                .set(PREDICTION.TITLE, prediction.getTitle())
                .set(PREDICTION.BODY, prediction.getBody())
                .set(PREDICTION.DEADLINE, prediction.getDeadline())
                .execute();
    }

    private DSLContext getDsl() {
        return this.dslContext;
    }
}
