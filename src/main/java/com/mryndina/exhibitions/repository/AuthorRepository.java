package com.mryndina.exhibitions.repository;

import com.mryndina.exhibitions.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
