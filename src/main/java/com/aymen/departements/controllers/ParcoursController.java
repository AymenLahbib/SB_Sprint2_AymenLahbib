package com.aymen.departements.controllers;

import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aymen.departements.entities.Parcours;
import com.aymen.departements.service.ParcoursService;

@Controller
public class ParcoursController {

	@Autowired
	ParcoursService parcoursService;
	
	@RequestMapping("/showCreatePar")
	public String showCreatePar(ModelMap modelMap)
	{
	modelMap.addAttribute("parcours", new Parcours());
	modelMap.addAttribute("mode", "newPar");
	return "formParcours";
	}
	
	@RequestMapping("/saveParcours")
	public String saveParcours(@Valid Parcours produit,

			BindingResult bindingResult)
	{ 
		if (bindingResult.hasErrors()) return "formParcours";
		parcoursService.saveParcours(produit);
	return "redirect:/ListeParcourss";
	}
	
	@RequestMapping("/ListeParcourss")
	public String listeParcourss(ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "2") int size)
	{
		Page<Parcours> prods = parcoursService.getAllParcourssParPage(page, size);
	
	modelMap.addAttribute("parcourss", prods);
	modelMap.addAttribute("pages", new int[prods.getTotalPages()]);

	modelMap.addAttribute("currentPage", page);
	return "listeParcourss";
	}
	
	@RequestMapping("/supprimerParcours")
	public String supprimerParcours(@RequestParam("id") Long id,
	ModelMap modelMap,@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "2") int size)
	{
	parcoursService.deleteParcoursById(id);
	Page<Parcours> prods = parcoursService.getAllParcourssParPage(page,size);
	modelMap.addAttribute("parcourss", prods);
	modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	modelMap.addAttribute("size", size);
	return "listeParcourss";
	}
	
	@RequestMapping("/modifierParcours")
	public String editerParcours(@RequestParam("id") Long id,ModelMap modelMap)
	{
	Parcours p= parcoursService.getParcours(id);
	modelMap.addAttribute("parcours", p);
	modelMap.addAttribute("mode", "editPar");
	return "formParcours";
	}
	
	
	
	@RequestMapping("/updateParcours")
	public String updateParcours(@ModelAttribute("parcours") Parcours produit,
	ModelMap modelMap) throws ParseException

{

parcoursService.updateParcours(produit);
List<Parcours> prods = parcoursService.getAllParcourss();
modelMap.addAttribute("parcours", prods);
return "listeParcourss";}
}
