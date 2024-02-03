package com.fitapp.fitapp.service;

import org.springframework.stereotype.Service;
import java.util.List;

import com.fitapp.fitapp.repo.ExerciseRepo;
import com.fitapp.fitapp.model.Exercise;

import com.fitapp.fitapp.exception.ExercisetNotFoundException;

@Service
public class ExerciseService {
    private final ExerciseRepo exerciseRepo;

    public ExerciseService(ExerciseRepo exerciseRepo) {
        this.exerciseRepo = exerciseRepo;
    }

    public Exercise addExercise(Exercise exercise) {
        System.out.println("new employee");
        if (exercise == null) { throw new NullPointerException("Exercise is not initialized");}
            
        return exerciseRepo.save(exercise);
    }

    public List<Exercise> findAllExercises() {
        return exerciseRepo.findAll();
    }

    public Exercise findExerciseById(Long id) {     
        return exerciseRepo.findExerciseById(id)
        .orElseThrow(() -> new ExercisetNotFoundException("Exercise by id " + id + " was not found"));
    }
    public void deleteExercise(Long id) {
        exerciseRepo.deleteExerciseById(id);
    }


}
