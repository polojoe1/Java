package com.joseph.bookClub.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.joseph.bookClub.models.Book;
import com.joseph.bookClub.models.User;
import com.joseph.bookClub.services.BookService;
import com.joseph.bookClub.services.UserService;


@Controller
public class HomePage {
	
	//DEPENDENCY INJECTION
	@Autowired
	private UserService userServ;
	@Autowired
	private BookService bookServ;
	
	
	
//	HOME PAGE! VERIFY SESSION 
	@GetMapping("/home")
    public String home(HttpSession session, Model model) {
		Long userId = (Long)session.getAttribute("user_id");
		List<Book> allBooks= bookServ.allBook();
		if(userId == null) {
			return "redirect:/";
		}
		else {
			User thisUser = userServ.findOne(userId);
			model.addAttribute("thisUser", thisUser);
			model.addAttribute("allBooks", allBooks);
		}
		return "home.jsp";
	}
	
//	LOGOUT! INVALIDATE SESSION!
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	
//	ADD BOOK ROUTES
	
	@GetMapping("/books/add")
	public String addBook(@ModelAttribute("newBook") Book book,HttpSession session) {
		return "addBook.jsp";
	}
	@PostMapping("/books/add/new")
	public String addBook(@Valid @ModelAttribute("newBook")Book book, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			return "addBook.jsp";
		}
		else {
			bookServ.createBook(book);
			return "redirect:/home";
		}
	}
	
	
	
	
//	INFO ABOUT ONE BOOK
	
	@GetMapping("/books/info/{id}")
	public String bookInfo(@PathVariable("id")Long id, Model model) {
		Book thisBook = bookServ.findBook(id);
		model.addAttribute("thisBook",thisBook);
		return "oneBook.jsp";
	}
}
