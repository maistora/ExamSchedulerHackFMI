package com.maistora.hackfmi.database.dao;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.maistora.hackfmi.AbstractTest;
import com.maistora.hackfmi.database.dao.UserDAO;
import com.maistora.hackfmi.database.repositories.UserDbRepository;


public class UserDAOTest extends AbstractTest {

	@Autowired
	private UserDbRepository repository;
	
	private UserDAO dao;
	
	@Before
	public void setup() {
		dao = new UserDAO(entityManager, repository);
	}
	
	@Test
	public void getUserById() {
		assertNotNull(dao.findUserById(11L));
	}
	
	@Test
	public void getUserByEmail() {
		assertNotNull(dao.findUserByEmail("admin"));
	}
}
