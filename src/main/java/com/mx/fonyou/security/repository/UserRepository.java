package com.mx.fonyou.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.fonyou.security.model.User;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
