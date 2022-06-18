package it.example.backend.repository;

import it.example.backend.model.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(collectionResourceRel = "categoria", path = "categoria")
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

  @Override
  @RestResource(exported = false)
  void deleteById(Long id);

  @Override
  @RestResource(exported = false)
  void delete(Categoria entity);
}
