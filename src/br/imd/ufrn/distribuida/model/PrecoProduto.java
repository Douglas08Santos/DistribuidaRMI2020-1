package br.imd.ufrn.distribuida.model;



import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PRECO_TABELA")
public class PrecoProduto implements Serializable{	
	@Id
	@Column(name = "TAB_ID")
	private long id;
	
	@Column(name = "TAB_PRECO")
	private Double preco;
	
	@ManyToOne
    @JoinColumn(name="PRO_ID")
    private Produto produto;
	
	@Column(name = "TAB_FRETE")
	private Double frete;
	
	@Column(name = "TAB_DATA")
	private Date dataDate = new Date();
	
	@ManyToOne
	@JoinColumn(name = "USU_ID")
	private Fornecedor fornecedor;
	
	public PrecoProduto() {
		// TODO Auto-generated constructor stub
	}
	
	public PrecoProduto(Produto produto, Double preco, Double frete, Fornecedor fornecedor) {
		this.preco = preco;
		this.produto = produto;
		this.frete = frete;
		this.fornecedor = fornecedor;
	}
	
	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	
	public Double getPreco() {
		return preco;
	}
	
	public Double getFrete() {
		return frete;
	}
	
}
