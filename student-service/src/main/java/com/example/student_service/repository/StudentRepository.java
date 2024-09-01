package com.example.student_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.student_service.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
}