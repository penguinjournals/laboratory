package com.penguinjournals.laboratory.service;

import com.penguinjournals.laboratory.domain.Prediction;
import com.penguinjournals.laboratory.domain.User;
import com.penguinjournals.laboratory.repository.PredictionRepository;
import com.penguinjournals.laboratory.repository.UserRepository;
import com.penguinjournals.laboratory.security.service.UserDetailsImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PredictionService {
    private PredictionRepository predictionRepository;
    private UserRepository userRepository;

    private static Logger logger = LoggerFactory.getLogger(PredictionService.class);

    public PredictionService(final PredictionRepository predictionRepository,
                             final UserRepository userRepository) {
        this.predictionRepository = predictionRepository;
        this.userRepository = userRepository;
    }

    public List<Prediction> latestPredicitions() {
        return this.predictionRepository.getPredictionsSortedByDate();
    }

    public void registerPrediction(final Prediction prediction, final UserDetailsImpl loggedUser) {
        User user = new User(loggedUser.getId(), loggedUser.getUsername(), loggedUser.getEmail());
        this.predictionRepository.savePrediction(prediction, user);
        logger.debug("Prediction: {}, User: {}", prediction, user);
    }
}
