package DAO;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import converterDoOnselectMenu.BaseEntity;


@Entity
@Table(name="despesas")
public class DespesasDAO implements Serializable{
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="despesas_id")
	private long id;
	
	@Column(name="despesas_nome", nullable=false)
	@NotNull
	@Size(min=1, max= 24, message = "campo nome despesa não pode ser em branco")
	private String nome;
	
	@Column(name="tipo_despesa", nullable=false)
	@NotNull(message="Selecione o tipo da despesa?")
	private String tipo;
	
	@Column(name="despesas_status", nullable=false)
	private boolean status;
	
	@ManyToOne
	@JoinColumn(name="usuario_id", referencedColumnName="usuario_id", nullable=false)
	private UsuariosDAO usuario;
	
	
	

	public DespesasDAO() {
		super();
		
	}


	public DespesasDAO(String nome, String tipo, boolean status, UsuariosDAO usuario){
		super();
		this.nome = nome;
		this.tipo = tipo;
		this.usuario = usuario;
		this.status = status;
		
	}

  //alterado o getid()
	public long getId() {
		return id;
	}
		  
	
	public void setId(long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public boolean getStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}


	public UsuariosDAO getUsuario() {
		return usuario;
	}


	public void setUsuario(UsuariosDAO usuario) {
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DespesasDAO other = (DespesasDAO) obj;
		if (id != other.id)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Despesas [id=" + id + ", nome=" + nome + ", tipo=" + tipo
				+ ", staus=" + status +", usuario=" + usuario + "]";
	}


	


	



	
	

}
