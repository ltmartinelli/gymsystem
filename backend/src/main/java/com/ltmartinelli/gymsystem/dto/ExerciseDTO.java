package com.ltmartinelli.gymsystem.dto;

import com.ltmartinelli.gymsystem.entities.Exercise;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

public class ExerciseDTO {

    private Long id;
    @NotBlank(message = "Campo requerido")
    private String name;
    @NotBlank(message = "Campo requerido")
    @Positive(message = "O valor deve ser positivo")
    private Integer sets;
    @NotBlank(message = "Campo requerido")
    @Positive(message = "O valor deve ser positivo")
    private Integer reps;
    @NotBlank(message = "Campo requerido")
    @Positive(message = "O valor deve ser positivo")
    private Integer weight;

    public ExerciseDTO() {
    }

    public ExerciseDTO(Long id, String name, Integer sets, Integer reps, Integer weight) {
        this.id = id;
        this.name = name;
        this.sets = sets;
        this.reps = reps;
        this.weight = weight;
    }

    public ExerciseDTO(Exercise entity) {
        id = entity.getId();
        name = entity.getName();
        sets = entity.getSets();
        reps = entity.getReps();
        weight = entity.getWeight();
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

    public Integer getSets() {
        return sets;
    }

    public void setSets(Integer sets) {
        this.sets = sets;
    }

    public Integer getReps() {
        return reps;
    }

    public void setReps(Integer reps) {
        this.reps = reps;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}
