package com.maistora.hackfmi.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maistora.hackfmi.database.entities.UserDB;

public interface UserDbRepository extends JpaRepository<UserDB, Long> {

}
