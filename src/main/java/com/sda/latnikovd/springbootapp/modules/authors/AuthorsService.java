package com.sda.latnikovd.springbootapp.modules.authors;

import java.util.List;

import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sda.latnikovd.springbootapp.modules.books.BookService;

// here we will put all the logic for authors model
@Service
public class AuthorsService {

	@Autowired
	private AuthorRepository authorRepository;

	@Autowired
	private BookService bookService;

	@Transactional(readOnly = true)
	public List<Author> findAll() {
		return authorRepository.findAll();
	}

	@Transactional(rollbackFor = Exception.class)
	public Author save(final Author author) {
		Validate.notNull(author, "author is undefined");
		Validate.notBlank(author.getName(), "name is blank for author '%s'", author);
		Validate.notBlank(author.getSurname(), "name is blank for author '%s'", author);
		Validate.notNull(author.getBirthDate(), "name is blank for author '%s'", author);

		return authorRepository.save(author);
	}

	@Transactional(rollbackFor = Exception.class)
	public void delete(final long authorId) {

		bookService.deleteByAuthorId(authorId);
		authorRepository.deleteById(authorId);
	}

	// We could also return null value if author was not found
	@Transactional(readOnly = true)
	public Author findById(final long authorId) {
		return authorRepository.findById(authorId).orElseThrow(() -> new RuntimeException(String.format("author with ID '%s' was not found", authorId)));
	}

	// we are returning List of Authors here since there can be multiple search results
	@Transactional(readOnly = true)
	public List<Author> findBySurname(final String surname) {
		// if we want to search by like condition (partial search) we can call
		return authorRepository.findBySurnameLike("%" + surname + "%");

		// if we want to search by strict where:
		// return authorRepository.findBySurname(surname);
	}
}
