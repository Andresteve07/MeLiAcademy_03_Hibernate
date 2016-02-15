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
			
//			Empleado empleado = new Empleado("35104714", "Esteban", "Morales");

//			empleado.setDomicilio(domicilio);
//			area.setEmpleado(empleado);
			
//			GestorArea garea = new GestorArea(fabrica);
//			garea.insertarArea(area);
//			garea.listarAreas();
			
			
			Area area = new Area("DEV");
			Domicilio domicilio1 = new Domicilio("27 de Abril", 950, "Córdoba", "Córdoba", "Argentina");
			Domicilio domicilio2 = new Domicilio("9 de Julio", 1150, "Córdoba", "Córdoba", "Argentina");
			Empleado empleado1 = new Empleado("35104714", "Esteban", "Morales");
			empleado1.setArea(area);
			empleado1.setDomicilio(domicilio1);
			Empleado empleado2 = new Empleado("35104800", "Nicolas", "Morales");
			empleado2.setArea(area);
			empleado2.setDomicilio(domicilio2);
			Set<Empleado> empleados = new HashSet<>();
			empleados.add(empleado1);
			empleados.add(empleado2);
			area.setEmpleados(empleados);
			
			Set<CorreoElectronico> correos1 = new HashSet<CorreoElectronico>();
			CorreoElectronico correo1 = new CorreoElectronico("steve@gmail.com");
			correo1.setEmpleado(empleado1);
			CorreoElectronico correo2 = new CorreoElectronico("steve@mercadolibre.com");
			correo2.setEmpleado(empleado1);
			correos1.add(correo1);
			correos1.add(correo2);
			empleado1.setCorreos(correos1);
			
			Set<CorreoElectronico> correos2 = new HashSet<CorreoElectronico>();
			CorreoElectronico correo3 = new CorreoElectronico("nico@gmail.com");
			correo3.setEmpleado(empleado2);
			CorreoElectronico correo4 = new CorreoElectronico("nico@mercadolibre.com");
			correo4.setEmpleado(empleado2);
			correos2.add(correo3);
			correos2.add(correo4);
			empleado2.setCorreos(correos2);
			System.out.println(empleado1);
			GestorEmpleados gemp = new GestorEmpleados(fabrica);
			System.out.println(empleado2);
			gemp.insertarEmpleado(empleado1);
			//gemp.insertarEmpleado(empleado2);
			
			
		} catch(Exception exception){
			System.err.println("No se pudo crear el objeto SessionFactory:" + exception);
			//throw new ExceptionInInitializerError(exception);
			exception.printStackTrace();
		}
	}

}
