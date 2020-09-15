package br.imd.ufrn.distribuida.model;

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
@Table(name="PRODUTO")
@SequenceGenerator(name="gen_produto",allocationSize=1)
public class Produto {
	@Id
    @Column(name="PRO_ID")
    @GeneratedValue(generator="gen_produto", strategy=GenerationType.SEQUENCE)
    private Long id;
	
	@Column(name = "PROD_NOME")
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "CAT_ID")
	private Categoria categoria;
	
	@Column(name = "PROD_DISPONIVEL")
	private Boolean disponivel;
	
	@ManyToOne
    @JoinColumn(name="MAR_ID")
    private Marca marca;
    
    /*produto repositorio*/
	
	public Produto() {
		// TODO Auto-generated constructor stub
	}
	
	public Produto(String nome, Boolean disponivel, Marca marca, Categoria categoria ) {
		this.nome = nome;
		this.disponivel = disponivel;
		this.marca = marca;
		this.categoria = categoria;
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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Boolean getDisponivel() {
		return disponivel;
	}

	public void setDisponivel(Boolean disponivel) {
		this.disponivel = disponivel;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	
	
	
}
