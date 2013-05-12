package com.maistora.spring.demo.database.dao;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.maistora.spring.demo.AbstractTest;
import com.maistora.spring.demo.database.repositories.UserEntityRepository;


public class UserDAOTest extends AbstractTest {

	@Autowired
	private UserEntityRepository repository;
	
	private UserDAO dao;
	
	@Before
	public void setup() {
		dao = new UserDAO(entityManager, repository);
	}
	
	@Test
	public void getUserById() {
		assertNotNull(dao.findUserById(1L));
	}
	
	@Test
	public void getUserByEmail() {
		assertNotNull(dao.findUserByEmail("dummy@mail.com"));
	}
}
