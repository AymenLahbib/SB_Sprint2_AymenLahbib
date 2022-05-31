package com.aymen.departements.entities;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Departement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDepartement;
	
	@NotNull
	@Size (min = 4,max = 35)
	private String nomDepartement;
	
	
	@Min(value = 10)
	@Max(value = 10000)
	private Double surfaceDepartement;
	
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent
	private Date dateCreation;
	@ManyToOne
	private Parcours parcours;
	
	
	public Departement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Departement(String nomDepartement, Double surfaceDepartement, Date dateCreation) {
		super();
		this.nomDepartement = nomDepartement;
		this.surfaceDepartement = surfaceDepartement;
		this.dateCreation = dateCreation;
	}
	
	
	
	
	public Long getIdDepartement() {
		return idDepartement;
	}
	public void setIdDepartement(Long idDepartement) {
		this.idDepartement = idDepartement;
	}
	public String getNomDepartement() {
		return nomDepartement;
	}
	public void setNomDepartement(String nomDepartement) {
		this.nomDepartement = nomDepartement;
	}
	public Double getSurfaceDepartement() {
		return surfaceDepartement;
	}
	public void setSurfaceDepartement(Double surfaceDepartement) {
		this.surfaceDepartement = surfaceDepartement;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	@Override
	public String toString() {
		return "Departement [idDepartement=" + idDepartement + ", nomDepartement=" + nomDepartement
				+ ", surfaceDepartement=" + surfaceDepartement + ", dateCreation=" + dateCreation + "]";
	}
	public Parcours getParcours() {
		return parcours;
	}
	public void setParcours(Parcours parcours) {
		this.parcours = parcours;
	}
	
	
	
	}