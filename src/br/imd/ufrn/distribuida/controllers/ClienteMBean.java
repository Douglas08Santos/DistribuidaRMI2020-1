package br.imd.ufrn.distribuida.controllers;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import br.imd.ufrn.distribuida.model.Cliente;
import br.imd.ufrn.distribuida.repository.ClienteRepository;

@Named("clienteMBean")
@ViewScoped
public class ClienteMBean implements Serializable{
	
	private Cliente cliente;
	
	@Inject
	private ClienteRepository clienteRepository;
	
	public Cliente getCliente() {
		if (cliente == null) {
			cliente = new Cliente();
		}
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	public List<Cliente> getList() {
		return clienteRepository.listAll();
	}
	
	@Transactional
	public String add() {
		clienteRepository.add(cliente);
		return "";
	}
}
