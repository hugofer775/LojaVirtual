package beans;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "pedido")
public class Pedido  {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ped_id")
	private int ped_id;
	
	@Column (name="ped_dataEmissao")
	@Type(type="date")    
	private Date dataEmissao;
	
	@Column (name="ped_status")
	private String status;
	
	@Column (name="ped_data_Autorizacao")
	@Type(type="date")
	private Date dataAutorizacao;
	
	@Column (name="ped_total")
	private float total;
	
	@Column (name="ped_desconto")
	private float desconto;
	
	@Column (name="ped_qtdparcelas")
	private float qtdParcelas;
	
	@ManyToOne
	@JoinColumn(name="pes_id")
	private Pessoa cliente;
	
	@ManyToOne
	@JoinColumn (name="fpg_id")
	private FormaPgto forma_pagamento;

	public int getPed_id() {
		return ped_id;
	}

	public void setPed_id(int ped_id) {
		this.ped_id = ped_id;
	}

	public Date getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDataAutorizacao() {
		return dataAutorizacao;
	}

	public void setDataAutorizacao(Date dataAutorizacao) {
		this.dataAutorizacao = dataAutorizacao;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public float getDesconto() {
		return desconto;
	}

	public void setDesconto(float desconto) {
		this.desconto = desconto;
	}

public float getQtdParcelas() {
		return qtdParcelas;
	}

	public void setQtdParcelas(float qtdParcelas) {
		this.qtdParcelas = qtdParcelas;
	}

	public Pessoa getCliente() {
		return cliente;
	}

	public void setCliente(Pessoa cliente) {
		this.cliente = cliente;
	}

	public FormaPgto getForma_pagamento() {
		return forma_pagamento;
	}

	public void setForma_pagamento(FormaPgto forma_pagamento) {
		this.forma_pagamento = forma_pagamento;
	}


		
	

}
