package br.imd.ufrn.distribuida.controllers;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import br.imd.ufrn.distribuida.model.Produto;
import br.imd.ufrn.distribuida.repository.ProdutoRepository;

@Named("produtoMBean")
@ViewScoped
public class ProdutoMBean implements Serializable{
	
	private Produto produto;
	 
	@Inject
    private ProdutoRepository produtoRepository;
    
   

    public Produto getProduto() {
        if(produto == null)
            produto = new Produto();
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    public List<Produto> getList(){
        return produtoRepository.listAll();
    }
    
    @Transactional
    public String add(){
    	produtoRepository.add(produto);
    	return "produto_list.jsf?faces-redirect=true";
    }
}
