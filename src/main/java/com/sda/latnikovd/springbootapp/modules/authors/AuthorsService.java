package com.sda.latnikovd.springbootapp.modules.authors;

import java.util.List;

import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// here we will put all the logic for authors model
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
		if (author.getName() == null) {
			throw new RuntimeException("name is undefined");
		}

		// example validate usages
		Validate.notNull(author, "author is undefined");
		Validate.notBlank(author.getName(), "name is blank for author '%s'", author);

		return authorRepository.save(author);
	}
}
