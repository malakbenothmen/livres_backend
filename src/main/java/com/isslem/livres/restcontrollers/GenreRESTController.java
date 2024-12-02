package com.isslem.livres.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.isslem.livres.entities.Genre;
import com.isslem.livres.entities.Livre;
import com.isslem.livres.repositories.GenreRepository;
import com.isslem.livres.service.GenreService;
import com.isslem.livres.service.GenreServiceImpl;

@RestController
@RequestMapping("/api/genre")
@CrossOrigin("http://localhost:4200/rechercheParGenre")
public class GenreRESTController {
	
	@Autowired
	GenreRepository genreRepository;
	@Autowired
    GenreService genreService;
	
	
	@RequestMapping(method = RequestMethod.POST)
	public Genre getGenreById(@RequestBody Genre g) {
		return genreRepository.save(g);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Genre> getAllGenres(){
		return genreRepository.findAll();
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Genre getGenreById(@PathVariable("id") Long id) {
		return genreRepository.findById(id).get();
	}
	@RequestMapping(value="/update",method = RequestMethod.PUT)
	public Genre updateGenre(@RequestBody Genre genre) {
		return genreService.updateGenre(genre);
	}
	
	@RequestMapping(value="/delete/{id}",method = RequestMethod.DELETE)
	public void deleteGenre(@PathVariable("id") Long id) {
		 genreService.deleteGenreById(id);
	}
	
	


}
