package br.imd.ufrn.distribuida.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.imd.ufrn.distribuida.enumerate.TipoPontuacao;

@Entity
@Table(name = "PONTUACAO")
public class Pontuacao {
	@Id
	@Column(name = "PONT_ID")
	private long id;
	
	@Column(name = "PONT_DESC")
	private String descricao;
	
	@Enumerated
	@JoinColumn(name = "PONT_PONTUACAO")
	private TipoPontuacao tipoPontuacao;
	
	@ManyToOne
	@JoinColumn(name = "PONT_PONTUADO")
	private Usuario pontuado;
	
	@ManyToOne
	@JoinColumn(name = "PONT_PONTUADOR")
	private Usuario pontuador;
	
	public Pontuacao() {
		// TODO Auto-generated constructor stub
	}
	
	public Pontuacao(String descricao, TipoPontuacao tipoPontuacao, Usuario pontuado, Usuario pontuador) {
		this.descricao = descricao;
		this.tipoPontuacao = tipoPontuacao;
		this.pontuado = pontuado;
		this.pontuador = pontuador;				
				
	}
	
	public String getDescricao() {
		return descricao;
	}
	public Usuario getPontuado() {
		return pontuado;
	}
	public Usuario getPontuador() {
		return pontuador;
	}
	public TipoPontuacao getTipoPontuacao() {
		return tipoPontuacao;
	}
}
