package com.maistora.spring.demo.web.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maistora.spring.demo.database.dao.UserDAO;
import com.maistora.spring.demo.database.entities.UserEntity;
import com.maistora.spring.demo.database.repositories.UserEntityRepository;
import com.maistora.spring.demo.database.transformers.UserTransformer;
import com.maistora.spring.demo.web.dto.UserDTO;

@Service
public class UserService {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private UserEntityRepository repository;

	public UserDTO getUserById(Long userId) {
		final UserDAO userDAO = new UserDAO(entityManager, repository);
		final UserEntity user = userDAO.findUserById(userId);
		
		return new UserTransformer().transform(user);
	}
	
	public UserDTO getUserById(String email) {
		final UserDAO userDAO = new UserDAO(entityManager, repository);
		final UserEntity user = userDAO.findUserByEmail(email);
		
		return new UserTransformer().transform(user);
	}

	public List<UserDTO> getUsers() {
		final UserDAO userDAO = new UserDAO(entityManager, repository);
		final List<UserEntity> dbUsers = userDAO.getUsers();
		final List<UserDTO> users = new ArrayList<UserDTO>();
		final UserTransformer transformer = new UserTransformer();
		
		for (UserEntity dbUser : dbUsers) {
			users.add(transformer.transform(dbUser));
		}
		return users;
	}
}