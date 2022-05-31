package com.aymen.departements.restcontrollers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aymen.departements.entities.Departement;
import com.aymen.departements.entities.Parcours;
import com.aymen.departements.service.DepartementService;
import com.aymen.departements.service.ParcoursService;


@RestController
@RequestMapping("/api")
@CrossOrigin
public class DepartementRESTController {

	@Autowired
	DepartementService produitService;
	
	
	
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Departement> getAllProduits() {
	return produitService.getAllDepartements();
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Departement getDepartemenById(@PathVariable("id") Long id) {
	return produitService.getDepartement(id);

	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public Departement createDepartement(@RequestBody Departement produit) {
	return produitService.saveDepartement(produit);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Departement updateDepartement(@RequestBody Departement produit) {
	return produitService.updateDepartement(produit);
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteDepartement(@PathVariable("id") Long id)
	{
	produitService.deleteDepartementById(id);
	}
	
	@RequestMapping(value="/prodscat/{idPar}",method = RequestMethod.GET)
	public List<Departement> getDepartementsByParId(@PathVariable("idPar") Long idPar) {
	return produitService.findByParcoursIdPar(idPar);
	}
	
	
	
}
