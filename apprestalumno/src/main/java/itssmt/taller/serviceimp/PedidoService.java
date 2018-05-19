package itssmt.taller.serviceimp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import itssmt.taller.dao.ITPedidoDao;
import itssmt.taller.entity.TDetalle;
import itssmt.taller.entity.TPedido;
import itssmt.taller.modelo.Detalle;
import itssmt.taller.modelo.GenericResponse;
import itssmt.taller.modelo.Pedido;
import itssmt.taller.service.IPedidoService;

@Service
public class PedidoService implements IPedidoService{

	@Autowired
	ITPedidoDao pedidoDao;

	@Override
	public String save(Pedido pedido) {
		
		TPedido tPedido = new TPedido();
		tPedido.setCliente_Id(pedido.getCliente_id());
		tPedido.setEstado(pedido.getEstado());
		tPedido.setFecha(pedido.getFecha());
		tPedido.setImporte(pedido.getImporte());
		tPedido.setNo_pedido(pedido.getNo_pedido());
		
		pedidoDao.save(tPedido);
		
		return tPedido==null?"No se pudo guardar el pedido":"Se almaceno el pedido";
	}

	@Override
	public List<Pedido> getAll() {
		List<Pedido> listaP = new ArrayList<>();
		
		try {
			
			List<TPedido> lista  = pedidoDao.findAll();
			for (TPedido p : lista) {
				Pedido pedido = new Pedido();
				pedido.setCliente_id(p.getCliente_Id());
				pedido.setEstado(p.getEstado());
				pedido.setFecha(p.getFecha());
				pedido.setImporte(p.getImporte());
				pedido.setNo_pedido(p.getNo_pedido());
				
				List<Detalle> listDetalle = new ArrayList<>();
		    	for(TDetalle tDetalle : p.getTDetalles()) {
		    		Detalle detalle = new Detalle();
		    	    detalle.setCantidad(tDetalle.getCantidad());
		    	    detalle.setFolioDetalle(tDetalle.getFolioDetalle());
		    	   
		    	    detalle.setPedido_No_pedido(tDetalle.getPedido_No_pedido());
		    	    detalle.setPrecio(tDetalle.getPrecio());
		    	    detalle.setProducto(tDetalle.getProducto());
		    	    listDetalle.add(detalle);
		    	}
				pedido.setDetalle(listDetalle);
				listaP.add(pedido);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return listaP;
	}

	@Override
	public ResponseEntity<GenericResponse<Pedido>> buscarPorId(int id) {
		GenericResponse<Pedido> response = new GenericResponse<>();
		
		try {
			TPedido p = pedidoDao.findOne(id);
			Pedido pedido = new Pedido();
			
			pedido.setCliente_id(p.getCliente_Id());
			pedido.setEstado(p.getEstado());
			pedido.setFecha(p.getFecha());
			pedido.setImporte(p.getImporte());
			pedido.setNo_pedido(p.getNo_pedido());
			
			response.setCode(200);
			response.setMessage("Correcto");
			response.setResponse(pedido);
			
		}catch (Exception e) {
			e.printStackTrace();
			response.setCode(500);
			response.setMessage("Error inesperado");
			return new ResponseEntity<GenericResponse<Pedido>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<GenericResponse<Pedido>>(response, HttpStatus.OK);
	}
}
