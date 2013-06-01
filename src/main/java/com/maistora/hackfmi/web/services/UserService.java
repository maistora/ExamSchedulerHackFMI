package com.maistora.hackfmi.web.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maistora.hackfmi.database.dao.UserDAO;
import com.maistora.hackfmi.database.entities.UserDB;
import com.maistora.hackfmi.database.repositories.UserDbRepository;
import com.maistora.hackfmi.database.transformers.UserTransformer;
import com.maistora.hackfmi.web.dto.UserDTO;

@Service
public class UserService {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private UserDbRepository repository;

	public UserDTO getUserById(Long userId) {
		final UserDAO userDAO = new UserDAO(entityManager, repository);
		final UserDB user = userDAO.findUserById(userId);
		
		return new UserTransformer().transform(user);
	}
	
	public UserDTO getUserById(String email) {
		final UserDAO userDAO = new UserDAO(entityManager, repository);
		final UserDB user = userDAO.findUserByEmail(email);
		
		return new UserTransformer().transform(user);
	}

	public List<UserDTO> getUsers() {
		final UserDAO userDAO = new UserDAO(entityManager, repository);
		final List<UserDB> dbUsers = userDAO.getUsers();
		final List<UserDTO> users = new ArrayList<UserDTO>();
		final UserTransformer transformer = new UserTransformer();
		
		for (UserDB dbUser : dbUsers) {
			users.add(transformer.transform(dbUser));
		}
		return users;
	}
}