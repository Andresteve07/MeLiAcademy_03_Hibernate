package com.mercadolibre.academy.hibernate.controller;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mercadolibre.academy.hibernate.entity.Area;
import com.mercadolibre.academy.hibernate.entity.CorreoElectronico;
import com.mercadolibre.academy.hibernate.entity.Domicilio;
import com.mercadolibre.academy.hibernate.entity.Empleado;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			SessionFactory fabrica = new Configuration().configure().buildSessionFactory();
			Domicilio domicilio = new Domicilio("27 de Abril", 950, "Córdoba", "Córdoba", "Argentina");
			Empleado empleado = new Empleado("35104714", "Esteban", "Morales");
			Area area = new Area("DEV");
			empleado.setDomicilio(domicilio);
			area.setEmpleado(empleado);
//			GestorArea garea = new GestorArea(fabrica);
//			garea.insertarArea(area);
			GestorEmpleados gemp = new GestorEmpleados(fabrica);
//			gemp.insertarEmpleado(empleado);
//			garea.listarAreas();
			Set<CorreoElectronico> correos = new HashSet<CorreoElectronico>();
			CorreoElectronico correo1 = new CorreoElectronico("steve@gmail.com");
			correo1.setEmpleado(empleado);
			CorreoElectronico correo2 = new CorreoElectronico("steve@mercadolibre.com");
			correo2.setEmpleado(empleado);
			correos.add(correo1);
			correos.add(correo2);
			empleado.setCorreos(correos);
			gemp.insertarEmpleado(empleado);
			gemp.listarEmpleados();
			
			
		} catch(Throwable exception){
			System.err.println("No se pudo crear el objeto SessionFactory:" + exception);
			throw new ExceptionInInitializerError(exception);
		}
	}

}
