package com.aymen.departements.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.aymen.departements.entities.Departement;
import com.aymen.departements.entities.Parcours;

public interface DepartementService {

	Departement saveDepartement(Departement p);
	Departement updateDepartement(Departement p);
	void deleteDepartement(Departement p);
	void deleteDepartementById(Long id);
	Departement getDepartement(Long id);
	List<Departement> getAllDepartements();
	List<Parcours> getAllParcourss();
	
	List<Departement> findByNomDepartement(String nom);
	List<Departement> findByNomDepartementContains(String nom);
	List<Departement> findByNomSurface (String nom, Double prix);
	List<Departement> findByParcours (Parcours categorie);
	List<Departement> findByParcoursIdPar(Long id);
	List<Departement> findByOrderByNomDepartementAsc();
	List<Departement> trierDepartementsNomsSurface();
	
	Page<Departement> getAllDepartementsParPage(int page, int size);
}
