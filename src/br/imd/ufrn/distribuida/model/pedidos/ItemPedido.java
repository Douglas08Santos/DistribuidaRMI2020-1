package br.imd.ufrn.distribuida.model.pedidos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.imd.ufrn.distribuida.model.Produto;

@Entity
@Table(name = "ITEM_PEDIDO")
@SequenceGenerator(name = "gen_itemPedido", allocationSize = 1)
public class ItemPedido implements Serializable{
	
	@Id
	@Column(name = "ITEM_ID")
	@GeneratedValue(generator = "gen_itemPedido", strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "ITEM_PRODUTO")
	private Produto produto;
	
	@Column(name = "ITEM_QTD")
	private int quantidade;
	
	@Column(name = "ITEM_STATUS")
	private String status;
	
	@Column(name = "ITEM_FRETE")
	private Double frete;
	
	@Column(name = "ITEM_VALOR_UNITARIO")
	private Double valorUnitario;
	
	@Column(name = "ITEM_VALOR_TOTAL")
	private Double valorTotal;
	
	public ItemPedido() {
		// TODO Auto-generated constructor stub
	}
	
	public ItemPedido(Produto produto, int quantidade, Double frete, Double valorUnitario) {
		this.produto = produto;
		this.quantidade = quantidade;
		this.frete = frete;
		this.valorUnitario = valorUnitario;
	}
	
	public Produto getProduto() {
		return produto;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	public String getStatus() {
		return status;
	}
	public Double getFrete() {
		return frete;
	}
	public Double getValorUnitario() {
		return valorUnitario;
	}
	public Double getValorTotal() {
		this.valorTotal = (valorUnitario*quantidade)+frete;
		return valorTotal;
	}
}
