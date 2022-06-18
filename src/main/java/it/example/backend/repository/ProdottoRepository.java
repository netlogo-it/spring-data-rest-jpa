package it.example.backend.repository;

import java.util.List;
import it.example.backend.model.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.RequestParam;

@RepositoryRestResource(collectionResourceRel = "prodotto", path = "prodotto")
public interface ProdottoRepository extends JpaRepository<Prodotto, Long> {
	
    @RestResource(path = "cercapernome")
    List<Prodotto> findByName(@RequestParam("name") String name);
    
	
}