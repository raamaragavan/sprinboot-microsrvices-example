package com.example.school_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.school_service.model.School;

@Repository
public interface SchoolRepository extends JpaRepository<School,Integer> {
}