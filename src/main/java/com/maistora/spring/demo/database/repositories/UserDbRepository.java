package com.maistora.spring.demo.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maistora.spring.demo.database.entities.UserDB;

public interface UserDbRepository extends JpaRepository<UserDB, Long> {

}
