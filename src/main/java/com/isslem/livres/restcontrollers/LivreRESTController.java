package com.isslem.livres.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.isslem.livres.entities.Livre;
import com.isslem.livres.service.LivreService;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class LivreRESTController {
	
	@Autowired
	LivreService livreService;
	
	@RequestMapping(path="all", method = RequestMethod.GET)
	public List<Livre> getAllLivres() {
		return livreService.getAllLivres();
	}
	
	@RequestMapping(value="/getbyid/{id}",method = RequestMethod.GET)
	//@GetMapping("/getbyid/{id}")
	public Livre getLivreById(@PathVariable("id") Long id) {
		return livreService.getLivre(id);
	 }
	
	
	//@PostMapping("/addliv")
	@RequestMapping(value="/addliv",method = RequestMethod.POST)
	//@PreAuthorize("hasAuthority('ADMIN')")
	public Livre createLivret(@RequestBody Livre livre) {
		return livreService.saveLivre(livre);
	}
	
	@RequestMapping(value="/updateliv",method = RequestMethod.PUT)
	//@PutMapping("/updateliv")
	//@PreAuthorize("hasAuthority('ADMIN')")
	public Livre updateLivre(@RequestBody Livre livre) {
		return livreService.updateLivre(livre);
	}

	@RequestMapping(value="delliv/{id}",method = RequestMethod.DELETE)
	//@DeleteMapping("delliv/{id}")
	public void deleteLivre(@PathVariable("id") Long id)
	{
		livreService.deleteLivreById(id);
	}
	
	@RequestMapping(value="/livresGenre/{idGenre}",method = RequestMethod.GET)
	public List<Livre> getLivresByGenreId(@PathVariable("idGenre") Long idGenre) {
		return livreService.findByGenreIdGenre(idGenre);
	}
	
	@RequestMapping(value="/livresByName/{nom}",method = RequestMethod.GET)
	public List<Livre> findByNomLivreContains(@PathVariable("nom") String nom) {
		return livreService.findByNomLivreContains(nom);
	}


}
