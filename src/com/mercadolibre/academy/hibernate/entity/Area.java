package com.mercadolibre.academy.hibernate.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
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
	
	@OneToOne(cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Empleado empleado;
	
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	public Area(){
		
	}
	public Area(String nombre){
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
	@Override
	public String toString() {
		return "Area [id=" + id + ", nombre=" + nombre + ", empleado=" + empleado + "]";
	}
	
	
}
