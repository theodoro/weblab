package br.com.drogaria.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tbl_venda")
public class Venda {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ven_id")
	private Long id;
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "ven_horario", nullable = false)
	private Date horario;
	@Column(name = "ven_vlr_total", precision = 7, scale = 2, nullable = false)
	private BigDecimal valorTotal;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tbl_funcionarios_fun_id", referencedColumnName = "fun_id", nullable = false)
	private Funcionario funcionario;

	public Venda() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getHorario() {
		return horario;
	}

	public void setHorario(Date horario) {
		this.horario = horario;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

}
