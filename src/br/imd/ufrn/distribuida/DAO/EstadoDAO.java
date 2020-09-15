package br.imd.ufrn.distribuida.DAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import br.imd.ufrn.distribuida.model.Estado;
import br.imd.ufrn.distribuida.repository.EstadoRepository;

@Stateless
public class EstadoDAO implements EstadoRepository{
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional
	public void add(Estado estado) {
		if (estado.getUf() != estado.getUf()) {
			em.persist(estado);
		}else {
			em.merge(estado);
		}
		
	}


	@Override
	@Transactional
	public void remove(Estado estado) {
		Estado estadoRemovido = em.find(Estado.class, estado.getUf());
		em.remove(estadoRemovido);
		
	}

	@Override
	public Estado getEstado(String uf) {
		String sql = "SELECT e FROM ESTADO e"
				+ "WHERE e.uf = :uf";
		Query query = em.createQuery(sql);
		query.setParameter("uf", uf);
		
		try {
			return (Estado) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
		
	}

	@Override
	public List<Estado> listAll() {
		List<Estado> resultList = (List<Estado>) em.createQuery("SELECT e FROM ESTADO e").getResultList();
		return null;
	}

}
