package com.fitapp.fitapp;

import org.springframework.web.bind.annotation.RestController;

import com.fitapp.fitapp.service.ExerciseService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import com.fitapp.fitapp.model.Exercise;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/exercise")
public class ExerciseResource {
    private final ExerciseService exerciseService;

    public ExerciseResource(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Exercise>> getALllExercise() {
        List<Exercise> exercises = exerciseService.findAllExercises();
        return new ResponseEntity<>(exercises, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Exercise> getExerciseById(@PathVariable("id") Long id) {
        Exercise exercise = exerciseService.findExerciseById(id);
        return new ResponseEntity<>(exercise, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Exercise> addExercise(@RequestBody Exercise exercise) {
        Exercise newExercise = exerciseService.addExercise(exercise);
        return new ResponseEntity<>(newExercise, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteExerciseById(@PathVariable("id") Long id ) {
        exerciseService.deleteExercise(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
    
