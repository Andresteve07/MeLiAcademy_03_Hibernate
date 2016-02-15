package com.mercadolibre.academy.hibernate.controller;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mercadolibre.academy.hibernate.entity.Area;

public class GestorArea {
	private static SessionFactory fabrica;
	
	public GestorArea(SessionFactory fabrica){
		GestorArea.fabrica = fabrica;
	}
	
	public int insertarArea(String nombre) {
		Session session = fabrica.openSession();
		Transaction transaction = null;
		int idArea = 0;
		try {
			transaction = session.beginTransaction();
			Area area = new Area(nombre);
			idArea = (int) session.save(area);
			transaction.commit();
		} catch (HibernateException hibernateException) {
			if (transaction != null) {
				transaction.rollback();
			}
			hibernateException.printStackTrace();
			System.out.println("ERROR DE ESCRITURA");
		} finally {
			session.close();
		}
		return idArea;
	}
	
	public int insertarArea(Area area) {
		Session session = fabrica.openSession();
		Transaction transaction = null;
		int idArea = 0;
		try {
			transaction = session.beginTransaction();
			idArea = (int) session.save(area);
			transaction.commit();
		} catch (HibernateException hibernateException) {
			if (transaction != null) {
				transaction.rollback();
			}
			hibernateException.printStackTrace();
			System.out.println("ERROR DE ESCRITURA");
		} finally {
			session.close();
		}
		return idArea;
	}

	public void listarAreas() {
		Session session = fabrica.openSession();
		Transaction transaction = null;//NO ES NECESARIA->LEER DOCS!!
		try {
			transaction = session.beginTransaction();
			@SuppressWarnings("unchecked")
			List<Area> areas = session.createQuery("FROM Area").list();
			for (Area area : areas) {
				System.out.println(area.toString());
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

	public void actualizarArea(int idArea, String nombre) {
		Session session = fabrica.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Area area = (Area) session.get(Area.class, idArea);
			area.setNombre(nombre);
			session.update(area);
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

	public void borrarArea(int idArea) {
		Session session = fabrica.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Area area = (Area) session.get(Area.class, idArea);
			session.delete(area);
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
		GestorArea managerArea = new GestorArea(fabrica);

		int id1 = managerArea.insertarArea("nombre1");
		int id2 = managerArea.insertarArea("nombre2");
		managerArea.insertarArea("nombre3");
		managerArea.listarAreas();
		System.out.println("----");
		managerArea.actualizarArea(id1, "xxxx");
		managerArea.borrarArea(id2);;
		managerArea.listarAreas();
	}
}
