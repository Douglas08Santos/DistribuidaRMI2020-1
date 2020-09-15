package br.imd.ufrn.distribuida.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Municipio")
@SequenceGenerator(name = "gen_municipio", allocationSize = 1)
public class Municipio implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "gen_municipio", strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name = "MUN_NOME")
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "EST_UF")
	private Estado estado;
	
	public Municipio() {
		// TODO Auto-generated constructor stub
	}
	
	public Municipio(String nome, Estado estado) {
		this.nome = nome;
		this.estado = estado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	
}
