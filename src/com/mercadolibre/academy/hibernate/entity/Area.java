package com.mercadolibre.academy.hibernate.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="area")
public class Area implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7555492062799460620L;
	
	@Id
	@GeneratedValue
	@Column(name="id_area")
	private int id;
	
	@Column(name="nombre")
	private String nombre;
	
	public Area(){
		
	}
	public Area(String nombre){
		
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
