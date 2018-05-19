package itssmt.taller.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="Detalle")
@NamedQuery(name="TDetalle.findAll", query="SELECT t FROM TDetalle t")
public class TDetalle implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int FolioDetalle;
	
    private int Pedido_No_pedido;
	
	private String Producto;

	private int Cantidad;
	
	private float Precio;
	
	//bi-directional many-to-one association to TMaestro
			@ManyToOne
			@JoinColumn(name="Pedido_No_pedido", insertable=false, updatable=false)
			private TPedido TPedido;
			
			
			/*
			 //bi-directional many-to-one association to Pedido
	@ManyToOne
	@JoinColumn(name="Pedido_No_pedido") 
			  
			 
			 */
			

			public int getFolioDetalle() {
				return FolioDetalle;
			}

			public void setFolioDetalle(int folioDetalle) {
				FolioDetalle = folioDetalle;
			}

			

			public int getPedido_No_pedido() {
				return Pedido_No_pedido;
			}

			public void setPedido_No_pedido(int pedido_No_pedido) {
				Pedido_No_pedido = pedido_No_pedido;
			}

			public String getProducto() {
				return Producto;
			}

			public void setProducto(String producto) {
				Producto = producto;
			}

			public int getCantidad() {
				return Cantidad;
			}

			public void setCantidad(int cantidad) {
				Cantidad = cantidad;
			}

			public float getPrecio() {
				return Precio;
			}

			public void setPrecio(float precio) {
				Precio = precio;
			}

			public TPedido getTPedido() {
				return TPedido;
			}

			public void setTPedido(TPedido tPedido) {
				TPedido = tPedido;
			}
	
			
	

}
