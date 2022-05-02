package br.com.nava.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.nava.processors.PetProcessor;
import br.com.nava.services.PetService;

@Component
public class PetPolling extends RouteBuilder{
	
	@Autowired
	private PetService petService;

	@Override
	public void configure() throws Exception{
		
		from("timer:pet?period=5000")
		.setHeader("id", simple("${random(0,3)}"))
		.to("rest:get:pets/{id}?host=http://localhost:8080")
		.process(new PetProcessor(petService))
		.log("${body}");
	}
}
