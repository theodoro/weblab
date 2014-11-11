package br.com.drogaria.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_produtos")
@NamedQueries({
		@NamedQuery(name = "Produto.Listar", query = "SELECT produto FROM Produto produto"),
		@NamedQuery(name = "Produto.BuscarPorId", query = "SELECT produto FROM Produto produto WHERE id = :id") })
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pro_id")
	private Long id;
	@Column(name = "pro_descricao", length = 50, nullable = false)
	private String descricao;
	@Column(name = "pro_preco", precision = 7, scale = 2, nullable = false)
	private BigDecimal preco;
	@Column(name = "pro_quantidade", nullable = false)
	private Integer quantidade;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tbl_fabricante_fab_id", referencedColumnName = "fab_id", nullable = false)
	private Fabricante fabricante;

	public Produto() {
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

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", descricao=" + descricao + ", preco="
				+ preco + ", quantidade=" + quantidade + ", fabricante="
				+ fabricante + "]";
	}

}
