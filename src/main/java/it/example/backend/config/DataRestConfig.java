package it.example.backend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import it.example.backend.model.entity.Prodotto;

@Configuration
public class DataRestConfig implements RepositoryRestConfigurer{
	
	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
		config.getExposureConfiguration().forDomainType(Prodotto.class)
			.withItemExposure((metdata, httpMethods) -> httpMethods.disable(HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE))
        	.withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE));
	}

}
