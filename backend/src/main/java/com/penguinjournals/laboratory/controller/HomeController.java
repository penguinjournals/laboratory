package com.penguinjournals.laboratory.controller;

import com.penguinjournals.laboratory.domain.Prediction;
import com.penguinjournals.laboratory.service.PredictionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HomeController {

    private PredictionService predictionService;

    public HomeController(final PredictionService predictionService) {
        this.predictionService = predictionService;
    }

    @GetMapping("/predictions")
    public List<Prediction> predictions() {
        return this.predictionService.latestPredicitions();
    }
}
