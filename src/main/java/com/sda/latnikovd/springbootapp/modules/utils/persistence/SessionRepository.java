package com.sda.latnikovd.springbootapp.modules.utils.persistence;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

public class SessionRepository {

	@Autowired
	private EntityManager entityManager;

	protected Session getSession() {
		return entityManager.unwrap(Session.class);
	}

}
