package br.imd.ufrn.distribuida.DAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import br.imd.ufrn.distribuida.model.Categoria;
import br.imd.ufrn.distribuida.model.Fornecedor;
import br.imd.ufrn.distribuida.repository.FornecedorRepository;

@Stateless
public class FornecedorDAO implements FornecedorRepository{
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional
	public void add(Fornecedor fornecedor) {
		if (fornecedor.getId() == 0) {
			em.persist(fornecedor);
		} else {
			em.merge(fornecedor);
		}
	}

	@Override
	public Fornecedor getFornecedor(Long id) {
		String sql = "SELECT f FROM FORNECEDOR f"
				+ "WHERE f.id = :id";
		
		Query q = em.createQuery(sql);
		q.setParameter("id", id);
		
		try {
			return (Fornecedor) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public List<Fornecedor> listAll() {
		List<Fornecedor> resultList = (List<Fornecedor>) em.createQuery("SELECT f FROM FORNECEDOR f").getResultList();
		return null;
	}

	

	

}
