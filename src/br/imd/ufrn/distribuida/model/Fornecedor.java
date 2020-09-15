package br.imd.ufrn.distribuida.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("F")
public class Fornecedor extends Usuario{
	
	
	@Column(name = "FORN_CPF")
	private String cpf;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	@OneToMany(mappedBy = "fornecedor")
	private List<PrecoProduto> precosProdutos = new ArrayList<PrecoProduto>();
	
	public Fornecedor() {
		// TODO Auto-generated constructor stub
	}
}
