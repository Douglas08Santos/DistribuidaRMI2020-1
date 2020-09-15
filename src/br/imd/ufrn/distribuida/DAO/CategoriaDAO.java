package br.imd.ufrn.distribuida.DAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;


import br.imd.ufrn.distribuida.model.Categoria;
import br.imd.ufrn.distribuida.repository.CategoriaRepository;


@Stateless
public class CategoriaDAO implements CategoriaRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional
	public void add(Categoria categoria) {
		if (categoria.getId() == 0) {
			em.persist(categoria);
		} else {
			em.merge(categoria);
		}
		
	}

	@Override
	@Transactional
	public void remove(Categoria categoria) {
		categoria = em.find(Categoria.class, categoria.getId());
		em.remove(categoria);
		
	}

	@Override
	public Categoria getCategoria(Integer id) {
		String sql = "SELECT c FROM CATEGORIA c"
				+ "WHERE c.id = :id";
		
		Query q = em.createQuery(sql);
		q.setParameter("id", id);
		
		try {
			return (Categoria) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public List<Categoria> listAll() {
		List<Categoria> resultList = (List<Categoria>) em.createQuery("SELECT c FROM CATEGORIA c").getResultList();
		return resultList;
		
	}
	
}
