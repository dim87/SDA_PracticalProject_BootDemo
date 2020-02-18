package com.sda.latnikovd.springbootapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sda.latnikovd.springbootapp.modules.authors.Author;
import com.sda.latnikovd.springbootapp.modules.authors.AuthorsService;

@RestController
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
}
