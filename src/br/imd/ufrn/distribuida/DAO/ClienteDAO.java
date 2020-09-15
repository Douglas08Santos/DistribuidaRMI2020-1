package br.imd.ufrn.distribuida.DAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import br.imd.ufrn.distribuida.model.Cliente;
import br.imd.ufrn.distribuida.repository.ClienteRepository;

@Stateless
public class ClienteDAO implements ClienteRepository{
	
	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	@Transactional
	public void add(Cliente cliente) {
		if (cliente.getId() != 0 ) {
			em.persist(cliente);
		}else {
			em.merge(cliente);
		}
		
	}

	@Override
	public Cliente getCliente(Long id) {
		String sql = "SELECT c FROM CLIENTE c"
				+ "WHERE c.id = :id";
		Query query = em.createQuery(sql);
		query.setParameter("id", id);
		
		try {
			return (Cliente) query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
		
	}

	@Override
	public Cliente getClienteByToken(String token) {
		String sql = "SELECT c FROM CLIENTE c"
				+ "WHERE c.token = :token";
		
		Query query = em.createQuery(sql);
		query.setParameter("token", token);
		
		try {
			return (Cliente) query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
		
	}

	@Override
	public List<Cliente> listAll() {
		List<Cliente> resultList = (List<Cliente>) em.createQuery("SELECT c FROM CLIENTE c").getResultList();
		return resultList;
	}
	
	
}
