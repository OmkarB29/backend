package com.example.plrepa.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Progress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int progressPercent;   // Example: 42%
    private int quizzesTaken;      // Example: 8 out of 10
    private String studyPlanWeek;  // Example: Week 2

    @OneToOne
    @JoinColumn(name = "user_id", unique = true) // One progress record per user
    private User user;
}
