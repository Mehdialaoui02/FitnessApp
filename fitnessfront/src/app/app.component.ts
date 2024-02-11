import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Exercise } from './exercise';
import { HttpErrorResponse } from '@angular/common/http';
import { ExerciseService } from './exercise.service';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit{
  public exercises: Exercise[];
  
  constructor(private exerciseService: ExerciseService){ this.exercises = []}

  ngOnInit(){
      this.getExercises();
  }
  public getExercises(): void {
    this.exerciseService.getExercises().subscribe(
      (response: Exercise[]) => {
        this.exercises = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message)
      }
    );
  }


}
