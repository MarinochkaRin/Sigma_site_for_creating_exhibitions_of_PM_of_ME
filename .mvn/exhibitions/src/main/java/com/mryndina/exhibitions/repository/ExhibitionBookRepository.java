package com.mryndina.exhibitions.repository;

import com.mryndina.exhibitions.entity.ExhibitionBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExhibitionBookRepository extends JpaRepository<ExhibitionBook, Long> {
}

