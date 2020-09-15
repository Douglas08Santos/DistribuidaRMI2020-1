package br.imd.ufrn.distribuida.repository;

import java.util.List;

import br.imd.ufrn.distribuida.model.Fornecedor;

public interface FornecedorRepository {
	public void add(Fornecedor fornecedor);
	public Fornecedor getFornecedor(Long id);
	public List<Fornecedor> listAll();
}
