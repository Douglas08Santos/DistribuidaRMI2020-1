package br.imd.ufrn.distribuida.repository;

import java.util.List;

import br.imd.ufrn.distribuida.model.Fornecedor;
import br.imd.ufrn.distribuida.model.PrecoProduto;
import br.imd.ufrn.distribuida.model.Produto;

public interface ProdutoRepository {
	public void add(Produto produto);
    public void remove(Produto produto);
    public Produto getProduto(Long id);
    public PrecoProduto getPreco(Produto produto, Fornecedor fornecedor);
   
    public List<Produto> listAll();
    public List<Produto> listProdutosCom(String nome);    
    public List<PrecoProduto> getMelhoresPrecos(Produto produto, int count);

    
}
