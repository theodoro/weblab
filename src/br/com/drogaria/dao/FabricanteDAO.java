package br.com.drogaria.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.util.HibernateUtil;

public class FabricanteDAO {

	public void salvar(Fabricante fabricante) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.save(fabricante);
			transaction.commit();
		} catch (RuntimeException ex) {
			if (transaction != null) {
				transaction.rollback();
			}

		} finally {
			session.close();
		}

	}

	@SuppressWarnings("unchecked")
	public List<Fabricante> listar() {

		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Fabricante> fabricantes = null;
		Query consulta = null;

		try {
			consulta = session.getNamedQuery("Fabricante.Listar");
			fabricantes = consulta.list();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			session.close();
		}

		return fabricantes;

	}
	
	public Fabricante buscarPorId(Long id) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Fabricante fabricante = null;
		Query consulta = null;

		try {
			consulta = session.getNamedQuery("Fabricante.BuscarPorId");
			
			consulta.setLong("id", id);
			fabricante = (Fabricante) consulta.uniqueResult();
		} catch (RuntimeException ex) {
			throw ex;
		} finally {
			session.close();
		}

		return fabricante;

	}
	
	public void excluir(Fabricante fabricante) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.delete(fabricante);
			transaction.commit();
		} catch (RuntimeException ex) {
			if (transaction != null) {
				transaction.rollback();
			}

		} finally {
			session.close();
		}

	}

}
