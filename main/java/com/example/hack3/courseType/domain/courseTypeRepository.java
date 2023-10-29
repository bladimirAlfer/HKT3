package com.example.hack3.courseType.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface courseTypeRepository extends JpaRepository<CourseType, Long> {
}
