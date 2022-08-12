package com.joseph.dojosAndNinjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joseph.dojosAndNinjas.models.Ninja;
import com.joseph.dojosAndNinjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	@Autowired
	NinjaRepository ninjaRepository;
	
	
	public List<Ninja> allNinjas() {
		return ninjaRepository.findAll();
	}
	
	
	public void deleteNinja(Long id) {
		ninjaRepository.deleteById(id);
	}

	// creates a book
	public Ninja createNinja(Ninja n) {
		return ninjaRepository.save(n);
	}

	// retrieves a book
	public Ninja findNinja(Long id) {
		Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
		if (optionalNinja.isPresent()) {
			return optionalNinja.get();
		} else {
			return null;
		}
	}
}
