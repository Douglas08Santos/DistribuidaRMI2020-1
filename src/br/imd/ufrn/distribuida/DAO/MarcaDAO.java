package br.imd.ufrn.distribuida.DAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import br.imd.ufrn.distribuida.model.Categoria;
import br.imd.ufrn.distribuida.model.Marca;
import br.imd.ufrn.distribuida.repository.MarcaRepository;

@Stateless
public class MarcaDAO implements MarcaRepository{
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional
	public void add(Marca marca) {
		if (marca.getId() == 0) {
			em.persist(marca);
		} else {
			em.merge(marca);
		}
		
	}

	@Override
	@Transactional
	public void remove(Marca marca) {
		Marca marcaRemovida = em.find(Marca.class, marca.getId());
		em.remove(marcaRemovida);
		
	}

	@Override
	public Marca get(Integer id) {
		String sql = "SELECT m FROM MARCA m"
				+ "WHERE m.id = :id";
		
		Query q = em.createQuery(sql);
		q.setParameter("id", id);
		
		try {
			return (Marca) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public List<Marca> listAll() {
		List<Marca> resultList = (List<Marca>) em.createQuery("SELECT m FROM MARCA m").getResultList();
		return resultList;
	}

}
