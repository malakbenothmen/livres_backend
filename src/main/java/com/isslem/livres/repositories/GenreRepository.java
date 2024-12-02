package com.isslem.livres.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.isslem.livres.entities.Genre;

@RepositoryRestResource(path = "genre")
@CrossOrigin("http://localhost:4200/") 
public interface GenreRepository  extends JpaRepository<Genre, Long> { 

}
