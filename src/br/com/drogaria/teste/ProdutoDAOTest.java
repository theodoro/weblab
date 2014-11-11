package br.com.drogaria.teste;

import java.math.BigDecimal;

import org.junit.Test;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.dao.ProdutoDAO;
import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.domain.Produto;



public class ProdutoDAOTest {
	
	@Test
	public void salvar(){
		
		FabricanteDAO fabDao = new FabricanteDAO();
		
		Fabricante fabricante = fabDao.buscarPorId(2L);
		
		Produto produto = new Produto();
		
		produto.setFabricante(fabricante);
		produto.setDescricao("XBOX ONE");
		produto.setPreco(new BigDecimal(799.99D));
		produto.setQuantidade(17);
		
		ProdutoDAO dao = new ProdutoDAO();
		dao.salvar(produto);
		
	}

}
