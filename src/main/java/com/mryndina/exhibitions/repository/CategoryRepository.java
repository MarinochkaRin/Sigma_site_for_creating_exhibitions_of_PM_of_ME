package com.mryndina.exhibitions.repository;

import com.mryndina.exhibitions.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
