package com.example.plrepa.service;

import com.example.plrepa.model.Subject;
import com.example.plrepa.repository.SubjectRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudyPlanService {

    private final SubjectRepository subjectRepository;

    public StudyPlanService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public List<Subject> getSubjectsByExam(Long examId) {
        return subjectRepository.findByExamId(examId);
    }
}
