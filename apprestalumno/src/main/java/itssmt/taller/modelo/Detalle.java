package itssmt.taller.modelo;

public class Detalle {
	
	private int pedido_No_pedido;
	private String producto;
	private int cantidad;
	private float precio;
	private int folioDetalle;
	
	
	
	
	public int getFolioDetalle() {
		return folioDetalle;
	}
	public void setFolioDetalle(int folioDetalle) {
		this.folioDetalle = folioDetalle;
	}
	
	public int getPedido_No_pedido() {
		return pedido_No_pedido;
	}
	public void setPedido_No_pedido(int pedido_No_pedido) {
		this.pedido_No_pedido = pedido_No_pedido;
	}
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	
	

}
