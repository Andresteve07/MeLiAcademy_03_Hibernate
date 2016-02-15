package com.mercadolibre.academy.hibernate.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name="empleado") 


public class Empleado implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5429494105996318021L;
	
	@Id
	@GeneratedValue
	@Column(name="id_empleado")
	private int id;
	
	@Column(name="dni")
	private String dni;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="apellido")
	private String apellido;
	
	@OneToOne(cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Domicilio domicilio;
	
	private Set<CorreoElectronico> correos;
	
	
//	@OneToOne(cascade=CascadeType.ALL)
//	private Area area;
//	
//	public Area getArea() {
//		return area;
//	}
//
//	public void setArea(Area area) {
//		this.area = area;
//	}

	public Set<CorreoElectronico> getCorreos() {
		return correos;
	}

	public void setCorreos(Set<CorreoElectronico> correos) {
		this.correos = correos;
	}

	public Empleado(){
		
	}
	
	public Domicilio getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}
	public Empleado(int id){
		this.id=id;
	}
	
	public Empleado(String dni, String nombre, String apellido){
		this.dni=dni;
		this.nombre=nombre;
		this.apellido=apellido;
	}
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Empleado [id=" + id + ", dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", domicilio="
				+ domicilio + this.correos+"]";
	}
	
	
	
	
}
