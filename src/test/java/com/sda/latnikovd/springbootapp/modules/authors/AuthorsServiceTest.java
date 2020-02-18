package com.sda.latnikovd.springbootapp.modules.authors;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.sda.latnikovd.springbootapp.BaseTest;

@RunWith(MockitoJUnitRunner.class)
class AuthorsServiceTest extends BaseTest {

	@InjectMocks
	private AuthorsService authorsService;

	@Mock
	private AuthorRepository authorRepository;

	@Test
	void findAll() {
		final List<Author> authors = Arrays.asList(new Author("John", "Doe", new Date()), new Author("John", "Doe2", new Date()),
												   new Author("John", "Doe3", new Date()));

		when(authorRepository.findAll()).thenReturn(authors);

		final List<Author> authorsReturned = authorsService.findAll();
		assertNotNull(authorsReturned);
		assertEquals(3, authorsReturned.size());
	}

	@Test
	void updateIsFailingWhenNameIsEmpty() {
		final Author author = new Author();
		author.setSurname("Doe");
		author.setBirthDate(new Date());

		Exception exception = assertThrows(RuntimeException.class, () -> {
			authorsService.save(author);
		});

		String expectedMessage = "name is undefined";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	void update() {
		final Author author = new Author();
		author.setName("John");
		author.setSurname("Doe");
		author.setBirthDate(new Date());

		when(authorRepository.save(author)).thenReturn(author);

		final Author result = authorsService.save(author);
		assertEquals(author, result);
	}
}
