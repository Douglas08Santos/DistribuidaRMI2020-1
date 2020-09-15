package br.imd.ufrn.distribuida.controllers;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import br.imd.ufrn.distribuida.model.Fornecedor;
import br.imd.ufrn.distribuida.repository.FornecedorRepository;

@Named("fornecedorMBean")
@ViewScoped
public class FornecedorMBean implements Serializable{
	private Fornecedor fornecedor;
	
	@Inject
	private FornecedorRepository fornecedorRepository;
	
	public Fornecedor getFornecedor() {
		 if(fornecedor == null)
	            fornecedor = new Fornecedor();
	        return fornecedor;
	}
	
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	
	public List<Fornecedor> getList() {
		return fornecedorRepository.listAll();
	}
	
	@Transactional
	public String add() {
		fornecedorRepository.add(fornecedor);
		return "fornecedor/list.jsf?faces-redirect=true";
	}
}
