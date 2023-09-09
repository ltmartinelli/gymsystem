import { ExerciseDTO } from './exercise.ts'

export type WorkoutDTO = {
    id: number,
    name: string,
    exercises: ExerciseDTO[]
}