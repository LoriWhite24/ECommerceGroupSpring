package com.cognixia.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognixia.ecommerce.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}