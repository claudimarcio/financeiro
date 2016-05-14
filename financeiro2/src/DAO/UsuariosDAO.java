package DAO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "usuario")
public class UsuariosDAO {
	
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "usuario_id")
	private long id;
	
	@Column(name = "usuario_nome", nullable = false)
	private String nome;
	
	@Column(name="usuario_senha", nullable=false)
	private String senha;
	
	@Column(name="usuario_autoridade", nullable=false)
	private String autoridade;
	
		
	public UsuariosDAO(String nome, String senha, String autoridade) {
		super();
		this.nome = nome;
		this.senha = senha;
		this.autoridade = autoridade;
	}

		
	public UsuariosDAO() {
		super();
		
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
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getAutoridade() {
		return autoridade;
	}

	public void setAutoridade(String autoridade) {
		this.autoridade = autoridade;
	}
	
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", senha=" + senha + ", autoridade="+ autoridade +"]";
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
		UsuariosDAO other = (UsuariosDAO) obj;
		if (id != other.id)
			return false;
		return true;
	}


	

}
