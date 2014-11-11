package br.com.drogaria.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.drogaria.domain.Produto;
import br.com.drogaria.util.HibernateUtil;

public class ProdutoDAO {
	
	public void salvar(Produto produto){
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Transaction transaction = null;
		
		try{
			transaction = session.beginTransaction();
			session.save(produto);
			transaction.commit();
		}catch(RuntimeException e){
			if(transaction != null){
				transaction.rollback();
			}
			
			throw e;
		}finally{
			session.close();
		}
	}

}
