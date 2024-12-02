package com.isslem.livres;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.isslem.livres.entities.Genre;
import com.isslem.livres.entities.Livre;
import com.isslem.livres.repositories.LivreRepository;

@SpringBootTest
class LivresApplicationTests {
	
	@Autowired
	private LivreRepository livreRepository;
	

	@Test
	public void testCreateLivre() {
		Livre livre = new Livre("It ends with us","coleen hoover",1500.500,new Date());
		livreRepository.save(livre);
	}
	
	@Test
	public void testFindLivre()
	{
		Livre l = livreRepository.findById(1L).get();
		System.out.println(l);
	}
	@Test
	public void testUpdateLivre()
	{
		Livre l = livreRepository.findById(1L).get();
		l.setPrixLivre(1000.0);
		livreRepository.save(l);
	}
	
	@Test
	public void testDeleteLivre()
	{
		livreRepository.deleteById(2L);;
	}

	@Test
	public void testListerTousLivres()
	{
		List<Livre> livs = livreRepository.findAll();
		for (Livre l : livs)
		{
			System.out.println(l);
		}
	}
	
	
	@Test
	public void testFindByNomLivre()
	{
		List<Livre> livres = livreRepository.findByNomLivre("it ends with us");
		for (Livre l : livres)
		{
		System.out.println(l);
	}
	}
	
	@Test
	public void testFindByNomPLivreContains ()
	{
		List<Livre> livres=livreRepository.findByNomLivreContains("ends");
		for (Livre l : livres)
		{
			System.out.println(l);
		} 
	}
	
	@Test
	public void testfindByNomPrix()
	{
		List<Livre> livres = livreRepository.findByNomPrix("it ends with us", 1000.0);
		for (Livre l : livres)
		{
			System.out.println(l);
		}
	}

	@Test
	public void testfindByGenre()
	{
		Genre g = new Genre();
		g.setIdGenre(1L);
		List<Livre> livres = livreRepository.findByGenre(g);
		for (Livre l : livres)
		{
			System.out.println(l);
		}
	}
	
	@Test
	public void findByGenreIdGenre()
	{
		List<Livre> livres = livreRepository.findByGenreIdGenre(2L);
		for (Livre l : livres)
		{
			System.out.println(l);
		}
	 }
	
	@Test
	public void testfindByOrderByNomLivreAsc()
	{
		List<Livre> livres =
		livreRepository.findByOrderByNomLivreAsc();
		for (Livre l : livres)
		{
			System.out.println(l);
		}
	}

	@Test
	public void testTrierLivresNomsPrix()
	{
		List<Livre> livres = livreRepository.trierLivresNomsPrix();
		for (Livre l : livres)
		{
			System.out.println(l);
		}
	}

}
