package com.joseph.dojosAndNinjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joseph.dojosAndNinjas.models.Dojo;
import com.joseph.dojosAndNinjas.repositories.DojoRepository;

@Service
public class DojoService {
	@Autowired
	DojoRepository dojoRepository;
	
	public List<Dojo> allDojos() {
		return dojoRepository.findAll();
	}
	
	
	public void deleteDojo(Long id) {
		dojoRepository.deleteById(id);
	}

	// creates a book
	public Dojo createDojo(Dojo d) {
		return dojoRepository.save(d);
	}

	// retrieves a book
	public Dojo findDojo(Long id) {
		Optional<Dojo> optionalDojo = dojoRepository.findById(id);
		if (optionalDojo.isPresent()) {
			return optionalDojo.get();
		} else {
			return null;
		}
	}
}

