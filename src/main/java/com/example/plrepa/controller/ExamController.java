package com.example.plrepa.controller; // <-- CRITICAL PACKAGE NAME FIX
import com.example.plrepa.model.Exam;
import com.example.plrepa.repository.ExamRepository;


import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/exams")
@CrossOrigin(origins = "*") // allow frontend access
public class ExamController {

    private final ExamRepository repo;

    public ExamController(ExamRepository repo) {
        this.repo = repo;
    }

    // Get all exams
    @GetMapping
    public List<Exam> getAllExams() {
        return repo.findAll();
    }

    // Add a new exam
    @PostMapping
    public Exam addExam(@RequestBody Exam exam) {
        return repo.save(exam);
    }

    // Get exam by ID
    @GetMapping("/{id}")
    public Exam getExamById(@PathVariable Long id) {
        return repo.findById(id).orElse(null);
    }

    // Delete exam
    @DeleteMapping("/{id}")
    public String deleteExam(@PathVariable Long id) {
        repo.deleteById(id);
        return "Exam deleted successfully!";
    }
}