package DAO;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;






@Entity
@Table(name="cadastro_despesas")
public class CadastroDespesasDAO implements Serializable{
	


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cadastro_despesas_id")
	private long id;
	
	@Column(name="cadastro_despesas_valor", nullable=false)
	@NotNull(message="valor não pode ser zero")
	@Min(value=1)
	private double valor;
	
	@Temporal(value=TemporalType.DATE)
	@Column(name="cadastro_despesas_data", nullable=false)
	@NotNull(message="Campo data não pode ser em branco")
	private Date data;
	
	@Column(name="cadastro_despesas_status", nullable=false)
	private boolean status;
	
	@ManyToOne
	@JoinColumn(name="usuario_id", referencedColumnName="usuario_id", nullable=false)
	private UsuariosDAO usuario;
	    
	@ManyToOne
	@JoinColumn(name="despesas_id",referencedColumnName="despesas_id", nullable=false)
	@Valid
	@NotNull(message="selecione uma despesa!")
	DespesasDAO despesas;


	public CadastroDespesasDAO() {
		super();
		
	}


	public CadastroDespesasDAO(double valor, Date data, boolean status, UsuariosDAO usuario,
			DespesasDAO despesas) {
		super();
		this.valor = valor;
		this.data = data;
		this.usuario = usuario;
		this.despesas = despesas;
		this.status = status;
	}


	public long getId() {
		return id;
	}
	
	
	public long getIdPara(long id) {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public double getValor() {
		return valor;
	}


	public void setValor(double valor) {
		this.valor = valor;
	}


	public Date getData() {
		return data;
	}


	public void setData(Date data) {
		this.data = data;
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


	public DespesasDAO getDespesas() {
		return despesas;
	}


	public void setDespesas(DespesasDAO despesas) {
		this.despesas = despesas;
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
		CadastroDespesasDAO other = (CadastroDespesasDAO) obj;
		if (id != other.id)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "CadastroDespesas [id=" + id + ", valor=" + valor + ", data="
				+ data + ", status=" + status +", usuario=" + usuario + ", despesas=" + despesas
				+ "]";
	}


	
	
}
