package com.aymen.departements.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data


@Entity
public class Parcours {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPar;
	@NotNull
	@Size (min = 4,max = 30)
	private String nomPar;
	
	@NotNull
	@Size (min = 4,max = 1000)
	private String descriptionPar;
	@JsonIgnore
	@OneToMany(mappedBy = "parcours")
	private List<Departement> departements;
	
	
	
	@Override
	public String toString() {
		return "Parcours [idPar=" + idPar + ", nomPar=" + nomPar + ", descriptionPar=" + descriptionPar
				+ ", departements=" + departements + "]";
	}
	
	public Long getIdPar() {
		return idPar;
	}

	public void setIdPar(Long idCat) {
		this.idPar = idCat;
	}

	public String getNomPar() {
		return nomPar;
	}

	public void setNomPar(String nomCat) {
		this.nomPar = nomCat;
	}

	public String getDescriptionPar() {
		return descriptionPar;
	}

	public void setDescriptionPar(String descriptionCat) {
		this.descriptionPar = descriptionCat;
	}

	public Parcours(String nomPar, String descriptionPar, List<Departement> departements) {
		super();
		this.nomPar = nomPar;
		this.descriptionPar = descriptionPar;
		this.departements = departements;
	}
	public Parcours() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
