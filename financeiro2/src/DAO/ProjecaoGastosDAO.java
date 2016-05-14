package DAO;

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

@Entity
@Table(name = "projecao_gastos")
public class ProjecaoGastosDAO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "projecao_gastos_id")
	private int id;

	@Temporal(value = TemporalType.DATE)
	@Column(name = "projecao_gastos_mes_ano", nullable = false)
	private Date data;

	@Column(name = "projecao_gastos_projecao",nullable = false, scale=2, precision=12, updatable=true)
	private double valor;

	@Column(name="projecao_gastos_status", nullable=false)
	private boolean status;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id", nullable = false)
	private UsuariosDAO usuario;

	public ProjecaoGastosDAO() {
		super();

	}

	public ProjecaoGastosDAO(Date data, double valor, boolean status, UsuariosDAO usuario) {
		super();
		this.data = data;
		this.valor = valor;
		this.usuario = usuario;
		this.status = status;
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
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
		result = prime * result + id;
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
		ProjecaoGastosDAO other = (ProjecaoGastosDAO) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "projecao_gastos [id=" + id + ", data=" + data + ", valor="
				+ valor + ", status=" + status +", usuario=" + usuario + "]";
	}

}
