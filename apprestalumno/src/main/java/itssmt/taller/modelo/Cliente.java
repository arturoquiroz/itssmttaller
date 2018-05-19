package itssmt.taller.modelo;

import java.util.List;

public class Cliente {

	private int idCliente;
	private String nombre;
	private String apellidos;
	private String direccion;
	private String telefono;
	private String fregistro;
	private List<Pedido> pedido;
	
	
	public List<Pedido> getPedido() {
		return pedido;
	}
	public void setPedido(List<Pedido> pedido) {
		this.pedido = pedido;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getFregistro() {
		return fregistro;
	}
	public void setFregistro(String fregistro) {
		this.fregistro = fregistro;
	}
	
}
