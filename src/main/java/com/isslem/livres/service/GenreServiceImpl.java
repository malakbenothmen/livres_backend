package com.isslem.livres.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isslem.livres.entities.Genre;
import com.isslem.livres.entities.Livre;
import com.isslem.livres.repositories.GenreRepository;


@Service
public class GenreServiceImpl implements GenreService {
	
	
	@Autowired
	GenreRepository genreRepository ;

	@Override
	public Genre updateGenre(Genre g) {
		Genre genreUpdated = genreRepository.save(g);
		return genreUpdated;
	}

	@Override
	public void deleteGenre(Genre g) {	
		genreRepository.delete(g);
		
	}

	@Override
	public void deleteGenreById(Long id) {
		
		genreRepository.deleteById(id);
	}

	@Override
	public Genre getGenre(Long id) {
		return genreRepository.findById(id).get();
	}

	@Override
	public List<Genre> getAllGenres() {
		// TODO Auto-generated method stub
		return null;
	}

}
