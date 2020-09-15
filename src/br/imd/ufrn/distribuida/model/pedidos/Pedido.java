package br.imd.ufrn.distribuida.model.pedidos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.imd.ufrn.distribuida.model.Cliente;
import br.imd.ufrn.distribuida.model.Fornecedor;


@Entity
@Table(name = "PEDIDO")
@SequenceGenerator(name = "gen_pedido", allocationSize = 1)
public class Pedido {
	@Id
	@Column(name = "PEDIDO_ID")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "USU_CLIENTE")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "USU_FORNECEDOR")
	private Fornecedor fornecedor;
	
	@Column(name = "PEDIDO_DATA")
	@Temporal(TemporalType.TIMESTAMP)
	private Date data = new Date();
	
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
	@JoinColumn(name = "PEDIDO_ID")
	private List<ItemPedido> itemPedidos = new ArrayList<ItemPedido>();
	
	@Column(name = "PEDIDO_REQUISICAO_CLIENTE")
	private Long requisicaoCliente;
	
	public Pedido() {
		// TODO Auto-generated constructor stub
	}
	
	public Pedido(Cliente cliente, Fornecedor fornecedor, Long requisicaoCliente) {
		this.cliente = cliente;
		this.fornecedor = fornecedor;
		this.requisicaoCliente = requisicaoCliente;
	}
	
	public Long getId() {
		return id;
	}
	
	public void addItem(ItemPedido item) {
		this.itemPedidos.add(item);
	}
	
	public List<ItemPedido> getItens() {
		return Collections.unmodifiableList(itemPedidos);
	}
	
	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	
	public Date getData() {
		return data;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public Long getRequisicaoCliente() {
		return requisicaoCliente;
	}
}
