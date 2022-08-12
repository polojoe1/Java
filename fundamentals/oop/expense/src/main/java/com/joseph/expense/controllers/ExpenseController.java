package com.joseph.expense.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.joseph.expense.models.Expense;
import com.joseph.expense.services.ExpenseService;

@Controller
public class ExpenseController {
	@Autowired
	ExpenseService expenseService;

	@GetMapping("/")
	public String index() {
		return "redirect:/expense/new";
	}

	@GetMapping("/expense/new")
	public String newBook(@ModelAttribute("expense") Expense expense, Model model) {
		List<Expense> allExpenses = expenseService.allExpenses();
		model.addAttribute("allExpenses", allExpenses);

		return "expense.jsp";
	}

	@PostMapping("/expense")
	public String create(@Valid @ModelAttribute("expense") Expense expense, BindingResult result, Model model) {
		List<Expense> allExpenses = expenseService.allExpenses();
		model.addAttribute("allExpenses", allExpenses);
		if (result.hasErrors()) {
			return "expense.jsp";
		} else {
			expenseService.createExpense(expense);
			return "redirect:/";
		}
	}
		
	@GetMapping("/expenses/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) {
	        Expense expense = expenseService.findExpense(id);
	        model.addAttribute("expense", expense);
	        return "edit.jsp";
	    }
	
	@PutMapping("/expenses/{id}")
    public String update(@Valid @ModelAttribute("expense") Expense expense, BindingResult result, Model model) {
		model.addAttribute("expense", expense);
		if (result.hasErrors()) {
            return "edit.jsp";
        } else {
            expenseService.updateExpense(expense);
            return "redirect:/";
        }
    }
	@RequestMapping(value="/expenses/{id}", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
        expenseService.delete(id);
        return "redirect:/";
    }
	@GetMapping("/expenses/{id}/info")
	public String oneEx(@PathVariable("id") Long id, Model model) {
		Expense expense = expenseService.findExpense(id);
        model.addAttribute("expense", expense);
        return "oneEx.jsp";
	}
	}

