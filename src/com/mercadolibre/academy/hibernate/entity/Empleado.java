package com.mercadolibre.academy.hibernate.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
	
	public Empleado(){
		
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
	
	public String toString(){
		return "[ID: "+this.id+" | "+"DNI: "+this.dni+" | "+"NOMBRE: "+this.nombre+" | "+"APELLIDO: "+this.apellido+"]";
	}
	
	
}
