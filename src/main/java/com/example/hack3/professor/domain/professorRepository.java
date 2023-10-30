package com.example.hack3.professor.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface professorRepository extends JpaRepository<Professor, Long> {
}
