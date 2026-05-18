package com.electricstepforrent.backend.repository;

import com.electricstepforrent.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}