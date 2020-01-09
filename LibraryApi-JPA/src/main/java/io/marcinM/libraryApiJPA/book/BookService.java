package io.marcinM.libraryApiJPA.book;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepo;
	
	public List<Book> getAllBooks(int id) {
		List<Book> books = new ArrayList<>();
		bookRepo.findAll().forEach(books::add);
		return books;
	}
	
	public Book getBook(int id) {
		return bookRepo.getOne(id);
	}
	
	public void addBook(Book book, int genreId) {
		bookRepo.save(book);
	}
	
	public void updateBook(Book book, int genreId, int id) {
		bookRepo.save(book);
	}
	
	public void deleteBook(int id) {
		bookRepo.deleteById(id);
	}
	

}
