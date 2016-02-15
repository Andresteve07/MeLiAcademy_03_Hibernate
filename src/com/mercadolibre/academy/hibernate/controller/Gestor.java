package com.mercadolibre.academy.hibernate.controller;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Gestor {
	private static SessionFactory fabrica;
	public int insertarObjeto(Object objeto){
		Session session = fabrica.openSession();
		Transaction transaction = null;
		int idObjeto = 0;
		try {
			transaction = session.beginTransaction();
			idObjeto = (int) session.save(objeto);
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
		return idObjeto;
	}
}
