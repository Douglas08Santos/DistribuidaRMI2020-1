package br.imd.ufrn.distribuida.repository;

import java.util.List;

import br.imd.ufrn.distribuida.model.Marca;

public interface MarcaRepository {
	public void add(Marca marca);
    public void remove(Marca marca);
    public Marca get(Integer id);
    public List<Marca> listAll();
}
