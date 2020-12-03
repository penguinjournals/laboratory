package com.penguinjournals.laboratory.dao;

import com.penguinjournals.laboratory.domain.Prediction;
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

    private DSLContext getDsl() {
        return this.dslContext;
    }
}
