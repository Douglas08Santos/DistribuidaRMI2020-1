package br.imd.ufrn.distribuida.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import br.imd.ufrn.distribuida.model.Cliente;
import br.imd.ufrn.distribuida.model.pedidos.Pedido;
import br.imd.ufrn.distribuida.repository.PedidoRepository;

public class PedidoDAO implements PedidoRepository{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional
	public void add(Pedido pedido) {
		if (pedido.getId() == 0) {
			em.persist(pedido);
		} else {
			em.merge(pedido);
		}
		
		
	}

	@Override
	@Transactional
	public void remove(Pedido pedido) {
		throw new NoResultException();
		
	}

	@Override
	public List<Pedido> listAll(Cliente cliente) {
		Query query = em.createQuery("select p from Pedido p where p.cliente = :cliente order by p.requisicaoCliente desc");
        query.setParameter("cliente", cliente);
        
        return(List<Pedido>) query.getResultList(); 
	}

}
