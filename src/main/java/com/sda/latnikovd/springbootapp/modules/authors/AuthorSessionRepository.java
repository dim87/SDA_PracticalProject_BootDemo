package com.sda.latnikovd.springbootapp.modules.authors;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.sda.latnikovd.springbootapp.modules.utils.persistence.SessionRepository;

@Repository
class AuthorSessionRepository extends SessionRepository {

	// example of writing a query using hibernate session and hql
	public List<Author> findAllByName(final String name) {
		final String hql = "select c from Author c where c.name = :name";
		final Query query = getSession().createQuery(hql);
		query.setParameter("name", name);
		return query.list();
	}
}
