package com.accolite.restapi_au.repository;

import com.accolite.restapi_au.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
