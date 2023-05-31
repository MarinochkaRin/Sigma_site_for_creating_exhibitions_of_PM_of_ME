package com.mryndina.exhibitions.service;

import com.mryndina.exhibitions.entity.Book;

import java.util.List;

public interface ModelService {

	public List<Book> findAllBooks();
	
	public List<Book> searchBooks(String keyword);

	public Book findBookById(int id);

	public void createBook(Book book);

	public void updateBook(Book book);

	public void deleteBook(int id);

}
