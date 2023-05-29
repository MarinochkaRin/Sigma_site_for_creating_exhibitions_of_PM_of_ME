package com.mryndina.exhibitions.service.impl;

import com.mryndina.exhibitions.entity.Book;
import com.mryndina.exhibitions.exception.NotFoundException;
import com.mryndina.exhibitions.repository.ModelRepository;
import com.mryndina.exhibitions.service.ModelService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ModelServiceImpl implements ModelService {

	private final ModelRepository modelRepository;

	public ModelServiceImpl(ModelRepository modelRepository) {
		this.modelRepository = modelRepository;
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	@Override
	public List<Book> findAllBooks() {
		return modelRepository.findAll();
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	@Override
	public List<Book> searchBooks(String keyword) {
		if (keyword != null) {
			return modelRepository.search(keyword);
		}
		return modelRepository.findAll();
	}

	@Override
	public Book findBookById(Long id) {
		return null;
	}

	@Override
	public void createBook(Book book) {
		modelRepository.save(book);
	}

	@Override
	public void updateBook(Book book) {
		modelRepository.save(book);
	}

	@Override
	public void deleteBook(Long id) {
		final Book book = modelRepository.findById(id)
				.orElseThrow(() -> new NotFoundException(String.format("Book not found with ID %d", id)));

		modelRepository.deleteById(book.getId());
	}

}
