package br.imd.ufrn.distribuida.model;

import java.io.Serializable;
import java.sql.Time;
import java.util.Timer;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.imd.ufrn.distribuida.util.UniqId;

@Entity
@Table(name = "Usuario")
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="ENT_TIPO", discriminatorType=DiscriminatorType.STRING, length = 1)
@DiscriminatorValue("U")
@SequenceGenerator(name = "gen_usuario", allocationSize = 1)
public class Usuario implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "USU_ID")
	@GeneratedValue(generator = "gen_usuario", strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name = "USU_NOME")
	private String nome;
	
	@Column(name = "USU_EMAIL")
	private String email;
	
	@Column(name = "USU_TEL")
	private String telefone;
	
	@Column(name = "USU_RUA")
	private String rua;
	
	@Column(name = "USU_BAIRRO")
	private String bairro;
	
	@ManyToOne
	@JoinColumn(name = "MUN_ID")	
	private Municipio municipio;
	
	@Column(name = "USU_ENDNUM")
	private int enderecoNum;
	
	@Column(name = "USU_CEP")
	private String cep;
	
	@Column(name = "USU_SENHA")
	private String senha;
	
	@Column(name = "USU_TOKEN")
	private String token;

	public Usuario() {
		// TODO Auto-generated constructor stub
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public int getEnderecoNum() {
		return enderecoNum;
	}

	public void setEnderecoNum(int enderecoNum) {
		this.enderecoNum = enderecoNum;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getToken() {
		return token;
	}
	
	public void setToken(String token) {
		this.token = UniqId.getInstance().getUniqIDHashString();;
	}
	

	
	

}
