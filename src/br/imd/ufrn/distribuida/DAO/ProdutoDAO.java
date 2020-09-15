package br.imd.ufrn.distribuida.DAO;

import java.io.Serializable;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import br.imd.ufrn.distribuida.model.Fornecedor;
import br.imd.ufrn.distribuida.model.PrecoProduto;
import br.imd.ufrn.distribuida.model.Produto;
import br.imd.ufrn.distribuida.repository.ProdutoRepository;


public class ProdutoDAO implements ProdutoRepository, Serializable {

	@PersistenceContext	
	private EntityManager em;
	
	@Override
	@Transactional
	public void add(Produto produto) {
		if (produto.getId() == 0) {
			em.persist(produto);
		} else {
			em.merge(produto);
		}
		
	}

	@Override
	@Transactional
	public void remove(Produto produto) {
		produto = em.find(Produto.class, produto.getId());
		em.remove(produto);
		
	}

	@Override
	public Produto getProduto(Long id) {
		String sql = "SELECT p FROM PRODUTO p"
				+ "WHERE p.id = :id";
		
		Query query = em.createQuery(sql);
		query.setParameter("id", id);
		
		try {
			return (Produto) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public PrecoProduto getPreco(Produto produto, Fornecedor fornecedor) {
		Query query = em.createQuery("select p from PrecoProduto p where p.produto = :produto and p.fornecedor = :fornecedor order by p.data desc");
		query.setParameter("produto", produto);
        query.setParameter("fornecedor", fornecedor);
        List<PrecoProduto> precosProduto = ( List<PrecoProduto> )query.getResultList();
        if(!precosProduto.isEmpty())
            return precosProduto.get(0);
        return null;
		
	}

	@Override
	public List<Produto> listAll() {
		List<Produto> resultList = (List<Produto>) em.createQuery("SELECT p FROM PRODUTO p").getResultList();
		return resultList;
	}

	@Override
	public List<Produto> listProdutosCom(String nome) {
		 Query query = em.createQuery("select p from Produto p where upper(p.nome) like :nome");
	     query.setParameter("nome", "%" + nome.toUpperCase() + "%");
	     List<Produto> produtosCom = (List<Produto>)query.getResultList();
	     return produtosCom;
		
	}

	@Override
	public List<PrecoProduto> getMelhoresPrecos(Produto produto, int count) {
		Query query = em.createQuery("select p from PrecoProduto p where p.produto = :produto order by p.preco asc");
		query.setParameter("produto", produto);
		query.setMaxResults(count);
		List<PrecoProduto> melhoresPrecoProdutos = (List<PrecoProduto>) query.getResultList();
        return melhoresPrecoProdutos;
	}

}
