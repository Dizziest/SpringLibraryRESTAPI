package io.marcinM.libraryApiJPA.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.marcinM.libraryApiJPA.genre.Genre;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;
	
	@RequestMapping("/genres/{id}/books")
	public List<Book> getAllBooks(@PathVariable int id) {
		return bookService.getAllBooks(id);
	}
	
	@RequestMapping("/genres/{genreId}/books/{id}")
	public Book getBook(@PathVariable int id) {
		return bookService.getBook(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/genres/{genreId}/books")
	public void addBook(@RequestBody Book book, @PathVariable int genreId) {
		book.setGenre(new Genre(genreId, ""));
		bookService.addBook(book, genreId);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/genres/{genreId}/books/{id}")
	public void updateBook(@RequestBody Book book, @PathVariable int genreId, @PathVariable int id) {
		book.setGenre(new Genre(genreId, ""));
		bookService.updateBook(book, genreId, id);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/genres/{genreId}/books/{id}")
	public void deleteBook(@PathVariable int id) {
		bookService.deleteBook(id);
	}
	
}
