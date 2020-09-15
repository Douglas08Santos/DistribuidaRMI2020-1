package br.imd.ufrn.distribuida.controllers;

import java.io.Serializable;
import java.util.List;


import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import br.imd.ufrn.distribuida.model.Categoria;
import br.imd.ufrn.distribuida.repository.CategoriaRepository;

@SuppressWarnings("serial")
@Named("categoriaMBean")
@ViewScoped
public class CategoriaMBean implements Serializable{
	
	private Categoria categoria;
	
	@Inject
	private CategoriaRepository categoriaRepository;
	
	public Categoria getCategoria() {
		if (categoria == null) {
			categoria = new Categoria();
		}
		return categoria;
	}
	
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public List<Categoria> getList() {
		return categoriaRepository.listAll();
	}
	
	@Transactional
	public String add() {
		categoriaRepository.add(categoria);
		return "/categoria/list.jsf?faces-redirect=true";
	}
}
