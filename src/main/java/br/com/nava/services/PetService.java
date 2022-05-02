package br.com.nava.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nava.entities.PetEntity;
import br.com.nava.repositories.PetRepository;

@Service
public class PetService {
	
	@Autowired
	private PetRepository petRepository;
	
	public PetEntity save(PetEntity obj) {
		return this.petRepository.save(obj);
	}

}
