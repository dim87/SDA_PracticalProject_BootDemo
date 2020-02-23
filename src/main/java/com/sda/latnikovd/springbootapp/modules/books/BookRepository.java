package com.sda.latnikovd.springbootapp.modules.books;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// please note that repository class is package private to minimize it's visibility
// only services should use corresponding repository classes!
@Repository
interface BookRepository extends JpaRepository<Book, Long> {

	List<Book> findAllByAuthorId(long authorId);
}
