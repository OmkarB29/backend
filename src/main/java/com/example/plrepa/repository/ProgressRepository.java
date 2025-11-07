package com.example.plrepa.repository;

import com.example.plrepa.model.Progress;
import com.example.plrepa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgressRepository extends JpaRepository<Progress, Long> {
    Progress findByUser(User user);
}
