package com.maistora.hackfmi.database.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.maistora.hackfmi.database.entities.UserDB;
import com.maistora.hackfmi.database.repositories.UserDbRepository;

public class UserDAO extends AbstractDAO<UserDB, Long> {

	private static final String HQL_GET_USER_BY_EMAIL = 
			" SELECT user " +
			" FROM UserDB user " +
			" WHERE user.email = :email ";
	
	public UserDAO(EntityManager entityManager, UserDbRepository repository) {
		super(entityManager, repository);
	}
	
	@SuppressWarnings("unchecked")
	public UserDB findUserByEmail(String email) {
		final Query query = entityManager.createQuery(HQL_GET_USER_BY_EMAIL);
		query.setParameter("email", email);
		
		final List<UserDB> users = query.getResultList();
		
		return firstOrNull(users);
	}

	public UserDB findUserById(Long userId) {
		return repository.findOne(userId);
	}

	public List<UserDB> getUsers() {
		return repository.findAll();
	}

}
