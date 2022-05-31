package com.aymen.departements.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.aymen.departements.entities.Departement;
import com.aymen.departements.entities.Parcours;
import com.aymen.departements.repos.DepartementRepository;
import com.aymen.departements.repos.ParcoursRepository;



@Service
public class DepartementServiceImpl implements DepartementService {

	@Autowired
	DepartementRepository departementRepository;
	
	@Autowired
	ParcoursRepository categorieRepository;
	
	@Override
	public Departement saveDepartement(Departement p) {
		return departementRepository.save(p);
	}

	@Override
	public Departement updateDepartement(Departement p) {
		return departementRepository.save(p);
	}

	@Override
	public void deleteDepartement(Departement p) {
		departementRepository.delete(p);
		
	}

	@Override
	public void deleteDepartementById(Long id) {
		departementRepository.deleteById(id);
	}

	@Override
	public Departement getDepartement(Long id) {
		return departementRepository.findById(id).get();
	}

	@Override
	public List<Departement> getAllDepartements() {
		return departementRepository.findAll();
	}

	@Override
	public Page<Departement> getAllDepartementsParPage(int page, int size) {
	return departementRepository.findAll(PageRequest.of(page, size));
	}
	
	@Override
	public List<Departement> findByNomDepartement(String nom) {
	return departementRepository.findByNomDepartement(nom);
	}
	@Override
	public List<Departement> findByNomDepartementContains(String nom) {
	return departementRepository.findByNomDepartementContains(nom);
	}
	
	@Override
	public List<Departement> findByNomSurface(String nom, Double prix) {
		return departementRepository.findByNomSurface(nom, prix);
	}
	@Override
	public List<Departement> findByParcours(Parcours categorie) {
	return departementRepository.findByParcours(categorie);
	}
	@Override
	public List<Departement> findByParcoursIdPar(Long id) {
	return departementRepository.findByParcoursIdPar(id);
	}
	@Override
	public List<Departement> findByOrderByNomDepartementAsc() {
	return departementRepository.findByOrderByNomDepartementAsc();
	}
	@Override
	public List<Departement> trierDepartementsNomsSurface() {
	return departementRepository.trierDepartementsNomsSurface();
	}
	
	@Override
	public List<Parcours> getAllParcourss() {
		
		return categorieRepository.findAll();
	}
	}
	

