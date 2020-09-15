package br.imd.ufrn.distribuida.repository;

import java.util.List;

import br.imd.ufrn.distribuida.model.Municipio;

public interface MunicipioRepository {
	public void add(Municipio municipio);
    public void remove(Municipio municipio);
    public List<Municipio> listAll();
}
