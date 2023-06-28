package com.ltmartinelli.gymsystem.repositories;

import com.ltmartinelli.gymsystem.entities.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanRepository extends JpaRepository<Plan, Long> {
}
