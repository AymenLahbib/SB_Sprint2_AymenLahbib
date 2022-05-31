package com.aymen.departements.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.aymen.departements.entities.Parcours;
import com.aymen.departements.repos.ParcoursRepository;

@Service
public class ParcoursServiceImpl implements ParcoursService {

	@Autowired
	ParcoursRepository produitRepository;
	
	@Override
	public Parcours saveParcours(Parcours p) {
		// TODO Auto-generated method stub
		return produitRepository.save(p);
	}

	@Override
	public Parcours updateParcours(Parcours p) {
		// TODO Auto-generated method stub
		return produitRepository.save(p);
	}

	@Override
	public void deleteParcours(Parcours p) {
		// TODO Auto-generated method stub
		produitRepository.delete(p);
	}

	@Override
	public void deleteParcoursById(Long id) {
		// TODO Auto-generated method stub
		produitRepository.deleteById(id);
	}

	@Override
	public Parcours getParcours(Long id) {
		// TODO Auto-generated method stub
		return produitRepository.findById(id).get();
	}

	@Override
	public List<Parcours> getAllParcourss() {
		// TODO Auto-generated method stub
		return produitRepository.findAll();
	}

	@Override
	public Page<Parcours> getAllParcourssParPage(int page, int size) {
		// TODO Auto-generated method stub
		return produitRepository.findAll(PageRequest.of(page, size));
	}

}
