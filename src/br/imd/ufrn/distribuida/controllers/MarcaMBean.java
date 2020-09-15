package br.imd.ufrn.distribuida.controllers;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import br.imd.ufrn.distribuida.model.Marca;
import br.imd.ufrn.distribuida.repository.MarcaRepository;

@Named("marcaMBean")
@ViewScoped
public class MarcaMBean implements Serializable {
	
	 private Marca marca;
	
	@Inject
    private MarcaRepository marcaRepository;
    
   
	public Marca getMarca() {
        if(marca == null)
            marca = new Marca();
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
    
    public List<Marca> getList(){
        return marcaRepository.listAll();
    }
    
    @Transactional
    public String add(){
        marcaRepository.add(marca);
        return "marca_list.jsf?faces-redirect=true";
    }
}
