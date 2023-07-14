package com.ltmartinelli.gymsystem.repositories;

import com.ltmartinelli.gymsystem.entities.Contract;
import com.ltmartinelli.gymsystem.entities.ContractPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ContractRepository extends JpaRepository<Contract, ContractPK> {

    @Query("SELECT obj FROM Contract obj " +
            "WHERE client_id = :clientId")
    Contract findByUser(Long clientId);
}
