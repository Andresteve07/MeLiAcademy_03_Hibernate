package com.mercadolibre.academy.hibernate.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="domicilio")
public class Domicilio implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3448433396569691210L;
	
	@Id
	@GeneratedValue
	@Column(name="id_domicilio")
	private int id;
	
	@Column(name="calle")
	private String calle;
	
	@Column(name="nro")
	private int nro;
	
	@Column(name="localidad")
	private String localidad;
	
	@Column(name="provincia")
	private String provincia;
	
	@Column(name="pais")
	private String pais;
	
	public Domicilio(){
		
	}
	public Domicilio(String calle, int nro, String localidad, String provincia, String pais){
		this.calle=calle;
		this.localidad=localidad;
		this.provincia=provincia;
		this.pais=pais;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public int getNro() {
		return nro;
	}
	public void setNro(int nro) {
		this.nro = nro;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	
	
}
