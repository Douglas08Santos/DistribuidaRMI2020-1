package br.imd.ufrn.distribuida.controllers;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import br.imd.ufrn.distribuida.model.Estado;
import br.imd.ufrn.distribuida.repository.EstadoRepository;

@Named("estadoMBean")
@ViewScoped
public class EstadoMBean implements Serializable {
	private Estado estado;
	
	@Inject
	private EstadoRepository estadoRepository;
	
	public Estado getEstado() {
		if (estado == null) {
			estado = new Estado();
		}
		return estado;
	}
	
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	
	public List<Estado> getList() {
		return estadoRepository.listAll();
	}
	
	@Transactional
	public String add() {
		estadoRepository.add(estado);
		return "estado/list.jsf?faces-redirect=true";
	}
}
