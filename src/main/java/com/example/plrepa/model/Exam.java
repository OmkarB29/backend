package com.example.plrepa.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String examName;

    @OneToMany(mappedBy = "exam", cascade = CascadeType.ALL)
    private List<Subject> subjects;
}
