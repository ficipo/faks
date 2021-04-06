package com.faks.faks.repository;

import com.faks.faks.model.entity.Maker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MakerRepository extends JpaRepository<Maker, Long>, JpaSpecificationExecutor<Maker> {
}
