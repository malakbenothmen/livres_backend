package com.isslem.livres.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isslem.livres.entities.Genre;
import com.isslem.livres.entities.Livre;
import com.isslem.livres.repositories.ImageRepository;
import com.isslem.livres.repositories.LivreRepository;

@Service
public class LivreServiceImpl implements LivreService {
	
	@Autowired
	LivreRepository livreRepository;
	
	@Autowired
	ImageRepository imageRepository;


	@Override
	public Livre saveLivre(Livre l) {
		return livreRepository.save(l);
	}

	/*
	@Override
	public Livre updateLivre(Livre l) {
		return livreRepository.save(l);
	}
	 */
	@Override
	public Livre updateLivre(Livre l) {
		//Long oldLivImageId = this.getLivre(l.getIdLivre()).getImage().getIdImage();
		//Long newLivImageId = l.getImage().getIdImage();
		Livre livUpdated = livreRepository.save(l);
		//if (oldLivImageId != newLivImageId) 
			//imageRepository.deleteById(oldLivImageId);
		return livUpdated;
	}
	
	
	@Override
	public void deleteLivre(Livre l) {
		livreRepository.delete(l);
		
	}
	
	@Override
	public void deleteLivreById(Long id) {
		Livre l = getLivre(id);
		//supprimer l'image avant de supprimer le produit
		try {
			Files.delete(Paths.get(System.getProperty("user.home")+"/images/"+l.getImagePath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		livreRepository.deleteById(id);
	}

	/*
	@Override
	public void deleteLivreById(Long id) {
		livreRepository.deleteById(id);
	}
	*/

	@Override
	public Livre getLivre(Long id) {
		return livreRepository.findById(id).get();
	}

	@Override
	public List<Livre> getAllLivres() {
		return livreRepository.findAll();
	}

	@Override
	public List<Livre> findByNomLivre(String nom) {
		return livreRepository.findByNomLivre(nom);
	}

	@Override
	public List<Livre> findByNomLivreContains(String nom) {
		return livreRepository.findByNomLivreContains(nom);
	}

	@Override
	public List<Livre> findByNomPrix(String nom, Double prix) {
		return livreRepository.findByNomPrix(nom, prix);
	}

	@Override
	public List<Livre> findByGenre(Genre genre) {
		return livreRepository.findByGenre(genre);
	}

	@Override
	public List<Livre> findByGenreIdGenre(Long id) {
		return livreRepository.findByGenreIdGenre(id);
	}

	@Override
	public List<Livre> findByOrderByNomLivreAsc() {
		return livreRepository.findByOrderByNomLivreAsc();
	}

	@Override
	public List<Livre> trierLivresNomsPrix() {
		return livreRepository.trierLivresNomsPrix();
	}

}
