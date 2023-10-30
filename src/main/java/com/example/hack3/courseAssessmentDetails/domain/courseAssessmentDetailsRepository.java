package com.example.hack3.courseAssessmentDetails.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface courseAssessmentDetailsRepository extends JpaRepository<courseAssessmentDetails, Long> {
}
