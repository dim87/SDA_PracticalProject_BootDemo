package com.sda.latnikovd.springbootapp.modules.authors;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// please note that repository class is package private to minimize it's visibility
// only services should use corresponding repository classes!
@Repository
interface AuthorRepository extends JpaRepository<Author, Long> {

	List<Author> findBySurname(String surname);

	List<Author> findBySurnameLike(String surname);
}
