package com.aymen.departements.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.aymen.departements.entities.Parcours;

public interface ParcoursService {

	Parcours saveParcours(Parcours p);
	Parcours updateParcours(Parcours p);
	void deleteParcours(Parcours p);
	void deleteParcoursById(Long id);
	Parcours getParcours(Long id);
	List<Parcours> getAllParcourss(); 
	Page<Parcours> getAllParcourssParPage(int page, int size);
}
