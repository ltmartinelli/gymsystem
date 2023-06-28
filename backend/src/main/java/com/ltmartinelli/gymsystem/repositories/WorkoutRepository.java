package com.ltmartinelli.gymsystem.repositories;

import com.ltmartinelli.gymsystem.entities.Workout;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkoutRepository extends JpaRepository<Workout, Long> {
}
