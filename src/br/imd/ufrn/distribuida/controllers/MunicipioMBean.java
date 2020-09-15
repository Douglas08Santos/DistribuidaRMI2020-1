package br.imd.ufrn.distribuida.controllers;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import br.imd.ufrn.distribuida.model.Municipio;
import br.imd.ufrn.distribuida.repository.MunicipioRepository;

@Named("MunicipioMBean")
@ViewScoped
public class MunicipioMBean implements Serializable {
	
	private Municipio municipio;
	
	@Inject
    private MunicipioRepository municipioRepository;
    
    

    public Municipio getMunicipio() {
        if(municipio == null)
            municipio = new Municipio();
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }
    
    public List<Municipio> getList(){
        return municipioRepository.listAll();
    }
    
    @Transactional
    public String add(){
        municipioRepository.add(municipio);
        return "municipio_list.jsf?faces-redirect=true";
    }
}
