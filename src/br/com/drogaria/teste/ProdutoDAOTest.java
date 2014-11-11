package br.com.drogaria.teste;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.dao.ProdutoDAO;
import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.domain.Produto;

public class ProdutoDAOTest {

	@Test
	@Ignore
	public void salvar() {

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

	@Test
	@Ignore
	public void buscarPorId() {

		ProdutoDAO dao = new ProdutoDAO();

		Produto produto = dao.buscarPorId(6L);

		System.out.println(produto);
	}
	
	@Test
	public void listar() {

		ProdutoDAO dao = new ProdutoDAO();

		List<Produto> produtos = dao.listar();
		
		System.out.println(produtos);
	}

}
