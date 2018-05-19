package itssmt.taller.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Cliente")
@NamedQuery(name="TCliente.findAll", query="SELECT t FROM TCliente t")
public class TCliente implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;

	private String Nombre;

	private String Apellidos;
	
	private String Direccion;

	private String Telefono;
	
	private String FRegistro;
	
	//bi-directional many-to-one association to TPedido
		@OneToMany(mappedBy="TCliente")
		private List<TPedido> TPedidos;
	


	public List<TPedido> getTPedidos() {
			return TPedidos;
		}

		public void setTPedidos(List<TPedido> tPedidos) {
			TPedidos = tPedidos;
		}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellidos() {
		return Apellidos;
	}

	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}

	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String direccion) {
		Direccion = direccion;
	}

	public String getTelefono() {
		return Telefono;
	}

	public void setTelefono(String telefono) {
		Telefono = telefono;
	}

	public String getFRegistro() {
		return FRegistro;
	}

	public void setFRegistro(String fRegistro) {
		FRegistro = fRegistro;
	}
	
	

}
