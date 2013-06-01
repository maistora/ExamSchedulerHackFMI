package com.maistora.hackfmi;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations="classpath:META-INF/test-application-context.xml")
@ContextConfiguration(locations="classpath:META-INF/application-context.xml")
public class AbstractTest {

	@PersistenceContext
	protected EntityManager entityManager;
	
	@Test
	public void abstractTest() {
		// this test is required so the 'mvn test' passes.
		// otherwise "Not executable test found error is triggered. 
	}
}
