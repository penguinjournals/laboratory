package com.penguinjournals.laboratory.controller;

import com.penguinjournals.laboratory.domain.MessageResponse;
import com.penguinjournals.laboratory.domain.Prediction;
import com.penguinjournals.laboratory.security.service.UserDetailsImpl;
import com.penguinjournals.laboratory.service.PredictionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
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

    @PostMapping("/prediction")
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_MODERATOR', 'ROLE_ADMIN')")
    public ResponseEntity<?> registerPrediction(@Valid @RequestBody final Prediction prediction) {
        UserDetailsImpl user = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        predictionService.registerPrediction(prediction, user);
        return ResponseEntity.ok(new MessageResponse("Prediction registered succesfully"));
    }

    @GetMapping("/profile")
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_MODERATOR', 'ROLE_ADMIN')")
    public String userAccess() {
        return "User content";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String adminAccess() {
        return "Admin content";
    }

}
