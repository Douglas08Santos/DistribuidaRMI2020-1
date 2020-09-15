package br.imd.ufrn.distribuida.repository;

import java.util.List;

import br.imd.ufrn.distribuida.model.Cliente;

public interface ClienteRepository {
	public void add(Cliente cliente);
	public Cliente getCliente(Long id);
	public Cliente getClienteByToken(String token);
	public List<Cliente> listAll();
	

	
}
