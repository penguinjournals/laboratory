package com.penguinjournals.laboratory.repository;

import com.penguinjournals.laboratory.dao.PredictionDao;
import com.penguinjournals.laboratory.domain.Prediction;
import com.penguinjournals.laboratory.domain.User;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import java.util.List;

import static com.penguinjournals.laboratory.jooq.tables.Prediction.PREDICTION;


@Repository
public class PredictionRepository {

    private PredictionDao predictionDao;

    public PredictionRepository(final PredictionDao predictionDao) {
        this.predictionDao = predictionDao;
    }

    public List<Prediction> getPredictionsSortedByDate() {
        return getPredictionDao().getPredictionsSortedByDate();
    }

    private PredictionDao getPredictionDao() {
        return this.predictionDao;
    }

    public void savePrediction(final Prediction prediction, final User user) {
        this.predictionDao.insertPredictionForUser(prediction, user);
    }
}
