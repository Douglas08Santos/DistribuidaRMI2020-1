package br.imd.ufrn.distribuida.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "MARCA")
@SequenceGenerator(name = "gen_marca", allocationSize = 1)
public class Marca {
	@Id
	@Column(name = "MAR_ID")
	@GeneratedValue(generator = "gen_marca", strategy = GenerationType.SEQUENCE)
	private long id;
	
	@Column(name =  "MAR_NOME")
	private String nome;
	
	public Marca() {
		// TODO Auto-generated constructor stub
	}
	
	public Marca(String nome){
		this.nome = nome;
	}
	
	public long getId() {
		return id;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
}
