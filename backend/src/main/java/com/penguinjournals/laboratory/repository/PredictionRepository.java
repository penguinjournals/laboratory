package com.penguinjournals.laboratory.repository;

import com.penguinjournals.laboratory.domain.Prediction;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import java.util.List;

import static com.penguinjournals.laboratory.jooq.tables.Prediction.PREDICTION;


@Repository
public class PredictionRepository {

    private final DSLContext dsl;

    public PredictionRepository(final DSLContext dslContext) {
        this.dsl = dslContext;
    }

    public List<Prediction> getPredictionsSortedByDate() {
        return getDsl()
                .select()
                .from(PREDICTION)
                .orderBy(PREDICTION.DEADLINE.desc())
                .fetchInto(Prediction.class);
    }

    private DSLContext getDsl() {
        return this.dsl;
    }
}
