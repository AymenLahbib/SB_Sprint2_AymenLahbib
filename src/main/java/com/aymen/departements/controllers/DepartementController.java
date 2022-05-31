package com.aymen.departements.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aymen.departements.entities.Departement;
import com.aymen.departements.entities.Parcours;
import com.aymen.departements.service.DepartementService;
import com.aymen.departements.service.ParcoursService;






@Controller
public class DepartementController {
	@Autowired
	DepartementService produitService;
	ParcoursService parcoursService;
	
	
	@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap) {
		List<Parcours> cats = produitService.getAllParcourss();
		Departement prod = new Departement();
		Parcours cat = new Parcours();
		cat = cats.get(0); // prendre la première catégorie de la liste
		prod.setParcours(cat); //affedter une catégorie par défaut au produit pour éviter le pb avec une catégorie null
		modelMap.addAttribute("departement", prod);
		
		modelMap.addAttribute("mode", "new");
		modelMap.addAttribute("parcourss", cats);
		return "formDepartement";
	}

	@RequestMapping("/saveDepartement")
	public String saveDepartement(@Valid Departement departement,
								   BindingResult bindingResult)
	{System.out.println(departement);
	System.out.println(bindingResult.getAllErrors());
		if (bindingResult.hasErrors()) return "formDepartement";
	produitService.saveDepartement(departement);
	return "redirect:/ListeDepartements";
	}
	
	@RequestMapping("/ListeDepartements")
	public String listeDepartements(ModelMap modelMap,

			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "3") int size)
		
	{
		Page<Departement> prods = produitService.getAllDepartementsParPage(page, size);
		modelMap.addAttribute("produits", prods);

		modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
		
		List<Parcours> cats = produitService.getAllParcourss();
		modelMap.addAttribute("parcours", cats);

		modelMap.addAttribute("currentPage", page);

		modelMap.addAttribute("currentPage", page);
		return "listeDepartements";
		}
	
	@RequestMapping("/supprimerDepartement")
	public String supprimerDepartement(@RequestParam("id") Long id,

			ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "2") int size)

			{
		produitService.deleteDepartementById(id);
		Page<Departement> prods = produitService.getAllDepartementsParPage(page,size);

		modelMap.addAttribute("produits", prods);
		modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "listeDepartements";
			}
	
	@RequestMapping("/modifierDepartement")
	public String editerDepartement(@RequestParam("id") Long id,ModelMap modelMap)
	{
		Departement p= produitService.getDepartement(id);
		List<Parcours> cats = produitService.getAllParcourss();
	modelMap.addAttribute("departement", p);
	modelMap.addAttribute("mode", "edit");
	modelMap.addAttribute("parcourss", cats);
	return "formDepartement";
	}
	@RequestMapping("/updateDepartement")
	public String updateDepartement(@ModelAttribute("departement") Departement produit,
	@RequestParam("date") String date,ModelMap modelMap) throws ParseException

{
//conversion de la date

SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
Date dateCreation = dateformat.parse(String.valueOf(date));
produit.setDateCreation(dateCreation);
produitService.updateDepartement(produit);
List<Departement> prods = produitService.getAllDepartements();
modelMap.addAttribute("produits", prods);
return "listeDepartements";

}
	
	@RequestMapping("/chercherNom")
    public String chercherProduit(@RequestParam("nomDepartement") String nom,
    		ModelMap modelMap,
    		@RequestParam (name="page",defaultValue = "0") int page,
    		@RequestParam (name="size", defaultValue = "2") int size)
    
    
    {     
	 	
    	  List <Departement> prods = produitService.findByNomDepartementContains(nom);
    	  
    	  modelMap.addAttribute("Produits",prods);
    	  
    	  return "resultat";}
	
	
	
	@RequestMapping("/chercherCat")
	  public String chercherCat(@RequestParam("idCat") int idCat,
	    		ModelMap modelMap,
	    		@RequestParam (name="page",defaultValue = "0") int page,
	    		@RequestParam (name="size", defaultValue = "2") int size)
	    {     
		 	
	    	  List <Departement> weapens = produitService.getAllDepartements();
	    	  weapens = weapens.stream()
	                  .filter(x -> x.getParcours().getIdPar() == idCat)
	                  .collect(Collectors.toList());
	    	  modelMap.addAttribute("produits",weapens);
	    	 List<Parcours> cats = produitService.getAllParcourss();
	    		modelMap.addAttribute("parcours", cats);
	    	
	    		modelMap.addAttribute("currentPage", page);
	    	  
	    	  return "listeDepartements";
	    }  
	
	
}
