package com.example.hack3.courseAssessment.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface courseAssessmentRepository extends JpaRepository<courseAssessment, Long> {
}
