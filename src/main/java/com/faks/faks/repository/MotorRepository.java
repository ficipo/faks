package com.faks.faks.repository;

import com.faks.faks.model.entity.Motor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


@Repository
public interface MotorRepository extends JpaRepository<Motor, Long>, JpaSpecificationExecutor<Motor> {
}
