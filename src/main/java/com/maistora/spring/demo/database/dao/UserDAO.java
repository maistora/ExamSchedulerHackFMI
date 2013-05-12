package com.maistora.spring.demo.database.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.maistora.spring.demo.database.entities.UserEntity;
import com.maistora.spring.demo.database.repositories.UserEntityRepository;

public class UserDAO extends AbstractDAO<UserEntity, Long> {

	private static final String HQL_GET_USER_BY_EMAIL = 
			" SELECT user " +
			" FROM UserEntity user " +
			" WHERE user.email = :email ";
	
	public UserDAO(EntityManager entityManager, UserEntityRepository repository) {
		super(entityManager, repository);
	}
	
	@SuppressWarnings("unchecked")
	public UserEntity findUserByEmail(String email) {
		final Query query = entityManager.createQuery(HQL_GET_USER_BY_EMAIL);
		query.setParameter("email", email);
		
		final List<UserEntity> users = query.getResultList();
		
		return firstOrNull(users);
	}

	public UserEntity findUserById(Long userId) {
		return repository.findOne(userId);
	}

	public List<UserEntity> getUsers() {
		return repository.findAll();
	}

}
