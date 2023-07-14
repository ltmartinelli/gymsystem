package com.ltmartinelli.gymsystem.dto;

import com.ltmartinelli.gymsystem.entities.Exercise;
import com.ltmartinelli.gymsystem.entities.Workout;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

public class WorkoutDTO {

    private Long id;
    @NotBlank(message = "Campo requerido")
    private String name;
    @NotEmpty(message = "Crie pelo menos um exercício para este treino")
    private final Set<ExerciseDTO> exercises = new HashSet<>();

    public WorkoutDTO() {
    }

    public WorkoutDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public WorkoutDTO(Workout entity) {
        id = entity.getId();
        name = entity.getName();
        for (Exercise exerc : entity.getExercises()) {
            exercises.add(new ExerciseDTO(exerc));
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<ExerciseDTO> getExercises() {
        return exercises;
    }

}
