package com.penguinjournals.laboratory.service;

import com.penguinjournals.laboratory.domain.Prediction;
import com.penguinjournals.laboratory.repository.PredictionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PredictionService {
    private PredictionRepository predictionRepository;

    public PredictionService(final PredictionRepository predictionRepository) {
        this.predictionRepository = predictionRepository;
    }

    public List<Prediction> latestPredicitions() {
        return this.predictionRepository.getPredictionsSortedByDate();
    }
}
