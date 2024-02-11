import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Exercise } from './exercise';
import { environment } from '../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ExerciseService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) {}

  public getExercises(): Observable<Exercise[]> {
    return this.http.get<Exercise[]>(`${this.apiServerUrl}/exercise/all`);
  }

  public addExercise(exercise: Exercise): Observable<Exercise> {
    return this.http.post<Exercise>(`${this.apiServerUrl}/exercise/add`, exercise);
  }

  public deleteExercise(exerciseId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/exercise/delete/${exerciseId}`);
  }

  
}
