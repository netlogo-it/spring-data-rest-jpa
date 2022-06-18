package it.example.backend.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import it.example.backend.model.entity.Prodotto;
import it.example.backend.repository.ProdottoRepository;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@BasePathAwareController
public class CustomApi {

    private ProdottoRepository prodottoRepository;
	
    @Autowired
	public CustomApi(ProdottoRepository prodottoRepository) {
		this.prodottoRepository=prodottoRepository;
	}

    @RequestMapping(method = RequestMethod.GET, value = "/operation1") 
    public @ResponseBody ResponseEntity<?> operation1() {
    	
    	List<Prodotto> result = prodottoRepository.findAll(); 
    	CollectionModel<Prodotto> resources = CollectionModel.of(result); 
    	resources.add(linkTo(methodOn(CustomApi.class).operation1()).withSelfRel()); 
        
    	return ResponseEntity.ok(resources);
    }
    
}