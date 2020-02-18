package com.sda.latnikovd.springbootapp.modules.authors;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface AuthorRepository extends JpaRepository<Author, Long> {

}
