package com.ltmartinelli.gymsystem.repositories;

import com.ltmartinelli.gymsystem.entities.Workout;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface WorkoutRepository extends JpaRepository<Workout, Long> {

    @Query("SELECT obj FROM Workout obj " +
            "WHERE user_id = :userId")
    Page<Workout> findByUser(Long userId, Pageable pageable);
}
