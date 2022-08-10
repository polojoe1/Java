package com.joseph.books.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.joseph.books.models.Book;
import com.joseph.books.repositories.BookRepository;

@Service
public class BookService {
	// adding the book repository as a dependency
	private final BookRepository bookRepository;

	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	// returns all the books
	public List<Book> allBooks() {
		return bookRepository.findAll();
	}
	
	public Book updateBook(Long id,String title, String desc, String lang, Integer numOfPages) {
		Book x =this.findBook(id);
		x.setTitle(title);
		x.setDescription(desc);
		x.setLanguage(lang);
		x.setNumberOfPages(numOfPages);
		return bookRepository.save(x);
	}
	
	public void deleteBook(Long id) {
		 bookRepository.deleteById(id);
	}

	// creates a book
	public Book createBook(Book b) {
		return bookRepository.save(b);
	}

	// retrieves a book
	public Book findBook(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if (optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}
}
