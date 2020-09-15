package br.imd.ufrn.distribuida.DAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.sun.mail.handlers.multipart_mixed;

import br.imd.ufrn.distribuida.model.Categoria;
import br.imd.ufrn.distribuida.model.Municipio;
import br.imd.ufrn.distribuida.repository.MunicipioRepository;

@Stateless
public class MunicipioDAO implements MunicipioRepository{
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional
	public void add(Municipio municipio) {
		if (municipio.getId() == 0) {
			em.persist(municipio);
		} else {
			em.merge(municipio);
		}
		
	}

	@Override
	@Transactional
	public void remove(Municipio municipio) {
		Municipio municipioRemovido = em.find(Municipio.class, municipio.getId());
		em.remove(municipio);
		
	}

	@Override
	public List<Municipio> listAll() {
		List<Municipio> resultList = (List<Municipio>) em.createQuery("SELECT m FROM MUNICIPIO m").getResultList();
		return resultList;
	}
	
}
