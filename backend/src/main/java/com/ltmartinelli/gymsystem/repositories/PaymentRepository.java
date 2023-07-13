package com.ltmartinelli.gymsystem.repositories;

import com.ltmartinelli.gymsystem.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
