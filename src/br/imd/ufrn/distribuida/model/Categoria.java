package br.imd.ufrn.distribuida.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CATEGORIA")
@SequenceGenerator(name = "gen_categoria", allocationSize = 1)
public class Categoria implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CAT_ID")
	@GeneratedValue(generator = "gen_categoria", strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	private String nome;
	
	public Categoria() {
		// TODO Auto-generated constructor stub
	}
	
	public Categoria(String nome) {
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
