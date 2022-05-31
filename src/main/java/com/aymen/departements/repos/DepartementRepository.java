package com.aymen.departements.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.aymen.departements.entities.Departement;
import com.aymen.departements.entities.Parcours;

@RepositoryRestResource(path = "rest")
public interface DepartementRepository extends JpaRepository<Departement, Long> {

	List<Departement> findByNomDepartement(String nom);
	List<Departement> findByNomDepartementContains(String nom);
	List<Departement> findByParcoursIdPar(Long id);
	List<Departement> findByOrderByNomDepartementAsc();
	
	
	
	@Query("select p from Departement p where p.nomDepartement like %:nom and p.surfaceDepartement > :prix")
	List<Departement> findByNomSurface (@Param("nom") String nom,@Param("prix") Double prix);
	
	@Query("select p from Departement p where p.parcours = ?1")
	List<Departement> findByParcours (Parcours categorie);
	
	@Query("select p from Departement p order by p.nomDepartement ASC, p.surfaceDepartement DESC")
	List<Departement> trierDepartementsNomsSurface ();
	
}
