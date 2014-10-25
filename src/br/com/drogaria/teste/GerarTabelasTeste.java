package br.com.drogaria.teste;

import org.junit.Test;

import br.com.drogaria.util.HibernateUtil;

public class GerarTabelasTeste {
	
	@Test
	public void Gerar(){
		
		HibernateUtil.getSessionFactory();
		HibernateUtil.getSessionFactory().close();
	}

}
