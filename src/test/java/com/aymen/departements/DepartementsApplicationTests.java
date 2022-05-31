package com.aymen.departements;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.aymen.departements.entities.Departement;
import com.aymen.departements.repos.DepartementRepository;

@SpringBootTest
class DepartementsApplicationTests {
	DepartementRepository departementRepository;
	@Test
	void contextLoads() {
	}

	@Test
	public void testFindByNomProduit()
	{
	List<Departement> prods = departementRepository.findByNomDepartement("Genie Electrique");

	for (Departement p : prods)
	{
	System.out.println(p);
	}

	}
	@Test
	public void testFindByNomProduitContains ()
	{
	List<Departement> prods=departementRepository.findByNomDepartementContains("Genie");

	for (Departement p : prods)
	{
	System.out.println(p);
	} }
	
	@Test
	public void testfindByNomPrix()
	{
	List<Departement> prods = departementRepository.findByNomSurface("Genie Electrique", 1500.0);
	for (Departement p : prods)
	{
	System.out.println(p);
	}

	}
}
