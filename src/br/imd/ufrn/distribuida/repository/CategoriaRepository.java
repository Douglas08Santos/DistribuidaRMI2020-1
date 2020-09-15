package br.imd.ufrn.distribuida.repository;

import java.util.List;

import br.imd.ufrn.distribuida.model.Categoria;

public interface CategoriaRepository {
	public void add(Categoria categoria);
	public void remove(Categoria categoria);
	public Categoria getCategoria(Integer id);
	public List<Categoria> listAll();
}
