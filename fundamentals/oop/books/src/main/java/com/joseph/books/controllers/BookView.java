package com.joseph.books.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.joseph.books.models.Book;
import com.joseph.books.services.BookService;
@Controller
public class BookView {
	@Autowired
	BookService bookService;
	
	@RequestMapping("/")
	public String index(Model model) {
		  List<Book> books = bookService.allBooks();
		model.addAttribute("books", books);
		return "index.jsp";
	}
	
	@RequestMapping("/books/{id}")
	public String page(
			@PathVariable("id")Long id,
			Model model) {
		Book myBook = bookService.findBook(id);
		model.addAttribute("myBook", myBook);
		return "page.jsp";
	}
}
