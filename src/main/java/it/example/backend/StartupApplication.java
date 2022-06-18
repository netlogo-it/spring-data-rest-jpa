package it.example.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import it.example.backend.model.entity.Prodotto;
import it.example.backend.model.entity.Categoria;
import it.example.backend.repository.CategoriaRepository;
import it.example.backend.repository.ProdottoRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class StartupApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdottoRepository prodottoRepository;
	
	@Override
	public void run(String... args) throws Exception {
		log.info("Startup Application...");
		Categoria categoria=new Categoria();
		categoria.setCategoria("Categoria");
		categoriaRepository.save(categoria);
		log.info("productCategory.id="+categoria.getId());
		
		for (int i=1;i<=10;i++) {
			Prodotto prodotto=new Prodotto();
			prodotto.setActive(true);
			prodotto.setCategoria(categoria);
			prodotto.setImageUrl(i+".jpg");
			prodotto.setName("Name-"+i);
			prodottoRepository.save(prodotto);
			log.info("product.id="+prodotto.getId());	
		}
	}

}
