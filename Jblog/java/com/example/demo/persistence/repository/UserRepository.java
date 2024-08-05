package com.example.demo.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.User;

@Repository("UserRepository")
public interface UserRepository extends JpaRepository<User, Integer>{

}