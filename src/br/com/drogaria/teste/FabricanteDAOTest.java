package br.com.drogaria.teste;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.domain.Fabricante;

public class FabricanteDAOTest {

	@Test
	@Ignore
	public void salvar() {

		Fabricante f1 = new Fabricante();
		Fabricante f2 = new Fabricante();

		f1.setDescricao("Bruno LTDA");

		f2.setDescricao("Priscila LTDA");

		FabricanteDAO dao = new FabricanteDAO();
		dao.salvar(f1);
		dao.salvar(f2);
	}

	@Test
	@Ignore
	public void listar() {

		FabricanteDAO dao = new FabricanteDAO();
		List<Fabricante> fabricantes = dao.listar();

		for (Fabricante fabricante : fabricantes) {
			System.out.println(fabricante);
		}
	}
	
	@Test
	@Ignore
	public void buscarPorId(){
		FabricanteDAO dao = new FabricanteDAO();
		Fabricante f1 = dao.buscarPorId(2L);
		
		Fabricante f2 = dao.buscarPorId(7L);
		
		System.out.println(f1);
		System.out.println(f2);
	}
	
	@Test
	public void excluir(){
		
		FabricanteDAO dao = new FabricanteDAO();
		
		Fabricante f = dao.buscarPorId(1L);
		dao.excluir(f);
		
	}
	
	

}
