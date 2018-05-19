package itssmt.taller.modelo;

import java.util.List;

public class Pedido {

	private int no_pedido;
	private int cliente_id;
	private String fecha;
	private String estado;
	private float importe;
	private List<Detalle> detalle;
	
	
	
	
	public List<Detalle> getDetalle() {
		return detalle;
	}
	public void setDetalle(List<Detalle> detalle) {
		this.detalle = detalle;
	}
	public int getNo_pedido() {
		return no_pedido;
	}
	public void setNo_pedido(int no_pedido) {
		this.no_pedido = no_pedido;
	}
	public int getCliente_id() {
		return cliente_id;
	}
	public void setCliente_id(int cliente_id) {
		this.cliente_id = cliente_id;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public float getImporte() {
		return importe;
	}
	public void setImporte(float importe) {
		this.importe = importe;
	}
	
		
	
}
