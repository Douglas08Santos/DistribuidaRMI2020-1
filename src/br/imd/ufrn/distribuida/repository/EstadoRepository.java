package br.imd.ufrn.distribuida.repository;

import java.util.List;

import br.imd.ufrn.distribuida.model.Estado;

public interface EstadoRepository {
	public void add(Estado estado);
	public void remove(Estado estado);
	public Estado getEstado(String uf);
	public List<Estado> listAll();
}
