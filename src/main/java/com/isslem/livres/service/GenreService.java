package com.isslem.livres.service;

import java.util.List;

import com.isslem.livres.entities.Genre;
import com.isslem.livres.entities.Livre;

public interface GenreService {
	
	Genre updateGenre(Genre g);
	void deleteGenre(Genre g);
	Genre getGenre(Long id);
	List<Genre> getAllGenres();
	void deleteGenreById(Long id);
}

