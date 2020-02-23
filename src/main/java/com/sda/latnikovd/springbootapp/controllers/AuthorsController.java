package com.sda.latnikovd.springbootapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sda.latnikovd.springbootapp.modules.authors.Author;
import com.sda.latnikovd.springbootapp.modules.authors.AuthorsService;

@RestController
// http://some_application.com/authors
@RequestMapping("/authors")
public class AuthorsController {

	@Autowired
	private AuthorsService authorsService;

	@GetMapping
	public List<Author> findAll() {
		return authorsService.findAll();
	}

	@PutMapping
	public Author create(@RequestBody Author author) {
		return authorsService.save(author);
	}

	@PatchMapping
	public Author update(@RequestBody Author author) {
		return authorsService.save(author);
	}

	// this method will be run when a GET request is sent to url "http://localhost:8080/authors/9" where 9 is ID of author to delete
	@GetMapping("/{authorId}")
	public Author get(@PathVariable long authorId) {
		return authorsService.findById(authorId);
	}

	// this method will be run when a DELETE request is sent to url "http://localhost:8080/authors/9" where 9 is ID of author to delete
	@DeleteMapping("/{authorId}")
	public void delete(@PathVariable long authorId) {
		// what do you think will happen if we try to delete an author with books?
		authorsService.delete(authorId);
	}

	// this method will be run when a GET request is sent to url "http://localhost:8080/authors/surname/London" where London is surname of author
	@GetMapping("/surname/{surname}")
	public List<Author> findBySurname(@PathVariable String surname) {
		return authorsService.findBySurname(surname);
	}
}
