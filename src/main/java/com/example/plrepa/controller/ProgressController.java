package com.example.plrepa.controller;

import com.example.plrepa.model.Progress;
import com.example.plrepa.model.User;
import com.example.plrepa.repository.ProgressRepository;
import com.example.plrepa.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/progress")
@CrossOrigin(origins = "*")
public class ProgressController {

    private final ProgressRepository progressRepository;
    private final UserRepository userRepository;

    public ProgressController(ProgressRepository progressRepository, UserRepository userRepository) {
        this.progressRepository = progressRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/{email}")
    public Progress getProgress(@PathVariable String email) {
        User user = userRepository.findByEmail(email);
        return progressRepository.findByUser(user);
    }

    @PostMapping("/update/{email}")
    public Progress updateProgress(@PathVariable String email, @RequestBody Progress newProgressData) {
        User user = userRepository.findByEmail(email);
        Progress progress = progressRepository.findByUser(user);

        if (progress == null) {
            progress = new Progress();
            progress.setUser(user);
        }

        progress.setProgressPercent(newProgressData.getProgressPercent());
        progress.setQuizzesTaken(newProgressData.getQuizzesTaken());
        progress.setStudyPlanWeek(newProgressData.getStudyPlanWeek());

        return progressRepository.save(progress);
    }
}
