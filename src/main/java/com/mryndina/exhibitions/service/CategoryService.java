package com.mryndina.exhibitions.service;

import com.mryndina.exhibitions.entity.Category;

import java.util.List;

public interface CategoryService {

	public List<Category> findAllCategories();

	public Category findCategoryById(Long id);

	public void createCategory(Category category);

	public void updateCategory(Category category);

	public void deleteCategory(Long id);

}
