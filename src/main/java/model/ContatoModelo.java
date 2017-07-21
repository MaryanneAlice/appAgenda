package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="tb_contatos")
@SequenceGenerator(name="idUser", sequenceName="tb_contatos_id_user_seq", allocationSize=1)
public class ContatoModelo implements Serializable{

	@Id
	@Column(name="id_user")
	@GeneratedValue(generator="idUser", strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="cellphone")
	private String telefoneCelular;
	
	@Column(name="phone")
	private String telefoneResidencial;
	
	@Column(name="email")
	private String eMail;

		
	 public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

		public String getNome() {
			return nome;
		}
	 	
	 	public void setNome(String nome) {
			this.nome = nome;
		}
		
		public String getTelefoneCelular() {
			return telefoneCelular;
		}
	
		public void setTelefoneCelular(String telefoneCelular) {
			this.telefoneCelular = telefoneCelular;
		}
	
		public String getTelefoneResidencial() {
			return telefoneResidencial;
		}
	
		public void setTelefoneResidencial(String telefoneResidencial) {
			this.telefoneResidencial = telefoneResidencial;
		}
	
		public String geteMail() {
			return eMail;
		}
	
		public void seteMail(String eMail) {
			this.eMail = eMail;
		}	
		
		public ContatoModelo(String nome, String telefoneCelular, String telefoneResidencial, String eMail) {
			setNome(nome);
			setTelefoneCelular(telefoneCelular);
			setTelefoneResidencial(telefoneResidencial);
			seteMail(eMail);
		}

		public ContatoModelo(){
			
		}
		
		public String toString() {
			return "Id: " + getId() + "  Nome: " + getNome() + "  Telefone celular: " + 
		getTelefoneCelular() + "  Telefone Residencial: " + getTelefoneResidencial() +
		"  E-mail: " + geteMail(); 
		}
}
