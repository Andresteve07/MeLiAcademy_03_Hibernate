package com.mercadolibre.academy.hibernate.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="correo_electronico")
public class CorreoElectronico implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3886004395199461136L;
	
	@Id
	@GeneratedValue
	@Column(name="id_correo_electronico")
	private int id;
	
	@Column(name="direccion_correo")
	private String direccionCorreo;
	
	@ManyToOne(cascade=CascadeType.ALL)//Confirmar anotación
	
	private Empleado empleado;
	
	@Override
	public String toString() {
		return "CorreoElectronico [id=" + id + ", direccionCorreo=" + direccionCorreo + "]";
	}
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	public CorreoElectronico(){
		
	}
	public CorreoElectronico(String direccionCorreo){
		this.direccionCorreo = direccionCorreo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDireccionCorreo() {
		return direccionCorreo;
	}
	public void setDireccionCorreo(String direccionCorreo) {
		this.direccionCorreo = direccionCorreo;
	}
	
}
