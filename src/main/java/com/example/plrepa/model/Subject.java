package com.example.plrepa.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String subjectName;
    private int weightage;

    @ManyToOne
    @JoinColumn(name = "exam_id")
    private Exam exam;
}
