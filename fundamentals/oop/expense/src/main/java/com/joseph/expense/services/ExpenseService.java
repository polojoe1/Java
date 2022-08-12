package com.joseph.expense.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joseph.expense.models.Expense;
import com.joseph.expense.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	@Autowired
	ExpenseRepository expenseRepository;
	
	public List<Expense> allExpenses(){
		return expenseRepository.findAll();
	}
	
	public Expense createExpense(Expense exp) {
		return expenseRepository.save(exp);
	}
	public Expense findExpense(Long id) {
		Optional<Expense> optionalExpense = expenseRepository.findById(id);
		if(optionalExpense.isPresent()) {
			return optionalExpense.get();
			}
		else {
			return null;
		}
	}
	public Expense updateExpense(Expense ex) {
		return expenseRepository.save(ex);
	}
	public void delete(Long id) {
		expenseRepository.deleteById(id);
	}
}

