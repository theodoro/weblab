package br.com.drogaria.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_fabricantes")
@NamedQueries({
		@NamedQuery(name = "Fabricante.Listar", query = "SELECT fabricante FROM Fabricante fabricante"),

		@NamedQuery(name = "Fabricante.BuscarPorId", query = "SELECT fabricante FROM Fabricante fabricante WHERE fabricante.id = :id") })
public class Fabricante {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "fab_id")
	private Long id;
	@Column(name = "fab_descricao", length = 50, nullable = false)
	private String descricao;

	public Fabricante() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Fabricante [id=" + id + ", descricao=" + descricao + "]";
	}

}
