package com.springboot.centreequestre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.centreequestre.model.Cheval;

@Repository
public interface ChevalRepository extends JpaRepository <Cheval, Long>{
}
