package com.mercadolibre.academy.hibernate.entity;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class GestorArea {
	private static SessionFactory fabrica;
	public int insertarArea(String nombre) {
		Session session = fabrica.openSession();
		Transaction transaction = null;
		int idEmpleado = 0;
		try {
			transaction = session.beginTransaction();
			Area area = new Area(nombre);
			idArea = (int) session.save(empleado);
			transaction.commit();
		} catch (HibernateException hibernateException) {
			if (transaction != null) {
				transaction.rollback();
			}
			hibernateException.printStackTrace();
		} finally {
			session.close();
		}
		return idEmpleado;
	}

	public void listarEmpleados() {
		Session session = fabrica.openSession();
		Transaction transaction = null;//NO ES NECESARIA->LEER DOCS!!
		try {
			transaction = session.beginTransaction();
			@SuppressWarnings("unchecked")
			List<Empleado> empleados = session.createQuery("FROM Empleado").list();
			for (Empleado empleado : empleados) {
				System.out.println(empleado.toString());
			}
			transaction.commit();
		} catch (HibernateException hibernateException) {
			if (transaction != null) {
				transaction.rollback();
			}	
			hibernateException.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void actualizarEmpleado(int idEmpleado, String dni, String nombre, String apellido) {
		Session session = fabrica.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Empleado empleado = (Empleado) session.get(Empleado.class, idEmpleado);
			empleado.setDni(dni);
			empleado.setNombre(nombre);
			empleado.setApellido(apellido);
			session.update(empleado);
			transaction.commit();
		} catch (HibernateException hibernateException) {
			if (transaction != null) {
				transaction.rollback();
			}	
			hibernateException.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void borrarEmpleado(int idEmpleado) {
		Session session = fabrica.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Empleado empleado = (Empleado) session.get(Empleado.class, idEmpleado);
			session.delete(empleado);
			transaction.commit();
		} catch (HibernateException hibernateException) {
			if (transaction != null) {
				transaction.rollback();
			}	
			hibernateException.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public static void main(String[] args) {
		try {
			fabrica = new Configuration().configure().buildSessionFactory();
		} catch (Throwable exception) {
			System.err.println("No se pudo crear el objeto SessionFactory." + exception);
			throw new ExceptionInInitializerError(exception);
		}
		GestorEmpleados managerEmpleado = new GestorEmpleados();

		int id1 = managerEmpleado.insertarEmpleado("dni1", "nombre1", "apellido1");
		int id2 = managerEmpleado.insertarEmpleado("dni2", "nombre2", "apellido2");
		managerEmpleado.insertarEmpleado("dni3", "nombre3", "apellido3");
		managerEmpleado.listarEmpleados();
		System.out.println("----");
		managerEmpleado.actualizarEmpleado(id1, "xxxx", "xxxxxxx", "xxxxxxxxx");
		managerEmpleado.borrarEmpleado(id2);;
		managerEmpleado.listarEmpleados();
	}
}
