package br.com.drogaria.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.drogaria.domain.Produto;
import br.com.drogaria.util.HibernateUtil;

@SuppressWarnings("unchecked")
public class ProdutoDAO {

	public void salvar(Produto produto) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			session.save(produto);
			transaction.commit();
		} catch (RuntimeException e) {
			if (transaction != null) {
				transaction.rollback();
			}

			throw e;
		} finally {
			session.close();
		}
	}

	public List<Produto> listar() {

		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Produto> produtos = null;

		try {
			Query consultar = session.getNamedQuery("Produto.Listar");
			produtos = consultar.list();
		} catch (RuntimeException e) {
			throw e;
		} finally {
			session.close();
		}
		return produtos;
	}

	public Produto buscarPorId(Long id) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Produto produto = null;
		try {
			Query consultar = session.getNamedQuery("Produto.BuscarPorId");
			consultar.setLong("id", id);

			produto = (Produto) consultar.uniqueResult();
		} catch (RuntimeException e) {
			throw e;
		} finally {
			session.close();
		}
		return produto;
	}

}
