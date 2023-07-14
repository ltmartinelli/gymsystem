package com.ltmartinelli.gymsystem.services;

import com.ltmartinelli.gymsystem.dto.ExerciseDTO;
import com.ltmartinelli.gymsystem.dto.WorkoutDTO;
import com.ltmartinelli.gymsystem.entities.Exercise;
import com.ltmartinelli.gymsystem.entities.Workout;
import com.ltmartinelli.gymsystem.repositories.ExerciseRepository;
import com.ltmartinelli.gymsystem.repositories.WorkoutRepository;
import com.ltmartinelli.gymsystem.services.exceptions.DatabaseException;
import com.ltmartinelli.gymsystem.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
public class WorkoutService {

    @Autowired
    private WorkoutRepository repository;

    @Autowired
    private ExerciseRepository exerciseRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private AuthService authService;

    @Transactional(readOnly = true)
    public WorkoutDTO findById(Long id) {
        Workout workout = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));
        authService.validateSelfOrAdmin(workout.getUser().getId());
        return new WorkoutDTO(workout);
    }

    @Transactional(readOnly = true)
    public Page<WorkoutDTO> findByUser(Pageable pageable) {

        Long userId = userService.getMe().getId();

        Page<Workout> result = repository.findByUser(userId, pageable);
        return result.map(workout -> new WorkoutDTO(workout));
    }

    @Transactional
    public WorkoutDTO insert(WorkoutDTO dto) {
        Workout workout = new Workout();
        copyDTOToWorkout(dto, workout);

        workout = repository.save(workout);

        return new WorkoutDTO(workout);
    }

    @Transactional
    public WorkoutDTO update(Long id, WorkoutDTO dto) {

        try {
            Workout workout = repository.getReferenceById(id);
            copyDTOToWorkout(dto, workout);
            workout = repository.save(workout);
            return new WorkoutDTO(workout);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }

    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha na integridade referencial");
        }
    }

    private void copyDTOToWorkout(WorkoutDTO dto, Workout entity) {
        entity.setName(dto.getName());
        entity.setUser(userService.authenticated());

        for (Exercise e : entity.getExercises()) {
            exerciseRepository.delete(e);
        }
        entity.getExercises().clear();

        for (ExerciseDTO e : dto.getExercises()) {
            Exercise exercise = new Exercise();
            exercise.setName(e.getName());
            exercise.setSets(e.getSets());
            exercise.setReps(e.getReps());
            exercise.setWeight(e.getWeight());
            exercise.setWorkout(entity);
            exercise = exerciseRepository.save(exercise);
            entity.getExercises().add(exercise);
        }
    }


}
