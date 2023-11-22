package com.wyden.banco.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wyden.banco.entity.Cliente;
import com.wyden.banco.util.HibernateUtil;

public class ClienteDao {

	public void create(Cliente cliente) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.persist(cliente);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public Cliente read(String cpf) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.get(Cliente.class, cpf);
		}
	}

	public void update(Cliente cliente) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.merge(cliente);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public void delete(String cpf) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Cliente cliente = session.get(Cliente.class, cpf);
			transaction = session.beginTransaction();
			session.remove(cliente);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
	
	public List<Cliente> getAll() {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("from Cliente", Cliente.class).list();
		}
	}
}