package com.sda.latnikovd.springbootapp.modules.books;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	@Transactional(rollbackFor = Exception.class)
	public void deleteByAuthorId(final long authorId) {
		final List<Book> allAuthorBooks = bookRepository.findAllByAuthorId(authorId);
		bookRepository.deleteAll(allAuthorBooks);
	}
}
