package com.mercadolibre.academy.hibernate.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="proyecto")
public class Proyecto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4173576114002067888L;
	
	@Id
	@GeneratedValue
	@Column(name="id_proyecto")
	private int id;
	
	@Column(name="nombre")
	private String nombre;
	
	public Proyecto(){
		
	}
	public Proyecto(String nombre){
		this.nombre=nombre;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
