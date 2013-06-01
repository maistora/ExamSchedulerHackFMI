package com.maistora.hackfmi.database.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import org.springframework.data.jpa.repository.JpaRepository;

public class AbstractDAO<OBJ, ID extends Serializable> {

	protected final EntityManager entityManager;
	protected final JpaRepository<OBJ, ID> repository;
	
	public AbstractDAO(EntityManager entityManager, JpaRepository<OBJ, ID> repository) {
		this.entityManager = entityManager;
		this.repository = repository;
	}
	
	@SuppressWarnings("unchecked")
	protected <T> T returnSafe(Query query, Class<T> resultClass) {
		try {
			return (T) query.getSingleResult();
		} catch (NoResultException ex) {
			return null;
		} catch (NonUniqueResultException ex) {
			return null;
		}
	}
	
	protected <T> T firstOrNull(final List<T> values) {
		return firstOr(values, null);
	}

	protected <T> T firstOr(final List<T> values, final T defaultValue) {
		return values == null || values.isEmpty() ? defaultValue : values.get(0);
	}
	
}
