package com.altimetrik.ee.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.altimetrik.ee.demo.entity.StockEntity;

@Repository
public interface StockRepository extends JpaRepository<StockEntity, Long> {

}
