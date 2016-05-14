package DAO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="receitas")
public class ReceitasDAO {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="receitas_id")
	private long id;
	
	@Column(name="receitas_nome", nullable=false)
	private String nome;
	
	@Column(name="tipo_receita", nullable=false)
	private String tipo;
	
	@Column(name="receitas_status", nullable=false)
	private boolean status;
	
	@ManyToOne
	@JoinColumn(name="usuario_id", referencedColumnName="usuario_id", nullable=false)
	private UsuariosDAO usuario;

	
	public ReceitasDAO() {
		super();
		
	}


	public ReceitasDAO(String nome, String tipo, boolean status, UsuariosDAO usuario) {
		super();
		this.nome = nome;
		this.tipo = tipo;
		this.usuario = usuario;
		this.status = status;
	}


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
		ReceitasDAO other = (ReceitasDAO) obj;
		if (id != other.id)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Receita [id=" + id + ", nome=" + nome + ", tipo=" + tipo
				+ ", status=" + status + ", usuario=" + usuario + "]";
	}

	
	
	
}
