package com.maistora.spring.demo.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maistora.spring.demo.database.entities.UserEntity;

public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {

}
