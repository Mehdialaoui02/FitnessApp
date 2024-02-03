package com.fitapp.fitapp.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fitapp.fitapp.model.Exercise;

public interface ExerciseRepo extends JpaRepository<Exercise, Long>{
    void deleteExerciseById(Long id);
    Optional<Exercise> findExerciseById(Long id);
}
