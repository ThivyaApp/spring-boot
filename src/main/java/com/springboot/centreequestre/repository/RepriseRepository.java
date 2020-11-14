package com.springboot.centreequestre.repository;

import com.springboot.centreequestre.model.Reprise;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface RepriseRepository extends JpaRepository<Reprise, Long> {
}
