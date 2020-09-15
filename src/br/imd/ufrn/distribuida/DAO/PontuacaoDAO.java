package br.imd.ufrn.distribuida.DAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import br.imd.ufrn.distribuida.model.Pontuacao;
import br.imd.ufrn.distribuida.repository.PontuacaoRepository;

public class PontuacaoDAO implements PontuacaoRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional
	public void add(Pontuacao pontuacao) {
		em.persist(pontuacao);
		
	}

}
