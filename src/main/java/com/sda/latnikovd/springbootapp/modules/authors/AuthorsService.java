package com.sda.latnikovd.springbootapp.modules.authors;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthorsService {

	@Autowired
	private AuthorRepository authorRepository;

	@Transactional(readOnly = true)
	public List<Author> findAll() {
		return authorRepository.findAll();
	}

	@Transactional(rollbackFor = Exception.class)
	public Author save(final Author author) {
		return authorRepository.save(author);
	}
}
