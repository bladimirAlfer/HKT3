package com.example.hack3.student.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface studentRepository extends JpaRepository<student, Long> {
}
