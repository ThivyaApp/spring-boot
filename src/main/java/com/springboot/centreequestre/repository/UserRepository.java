package com.springboot.centreequestre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.centreequestre.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
