package br.com.nava.processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.nava.entities.PetEntity;
import br.com.nava.services.PetService;

public class PetProcessor implements Processor {
	
	private PetService petService;
	
	public PetProcessor(PetService petService) {
		this.petService = petService;
	}

	@Override
	public void process(Exchange exchange) throws Exception {
		
		String petStr = exchange.getIn().getBody(String.class);
		System.out.println("petStr" + petStr);
		
		ObjectMapper mapper = new ObjectMapper();
		
		PetEntity pet = mapper.readValue(petStr, PetEntity.class);
		
		pet.setId(1);
		petService.save(pet);
		
		System.out.println("petObj " + pet);
		
		//EXERCÍCIO: SALVAR PET NO BANCO DE DADOS
		
	}
	
	

}
