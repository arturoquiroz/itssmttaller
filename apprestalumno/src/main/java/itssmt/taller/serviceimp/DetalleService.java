package itssmt.taller.serviceimp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import itssmt.taller.dao.ITDetalleDao;
import itssmt.taller.entity.TDetalle;
import itssmt.taller.modelo.Detalle;
import itssmt.taller.modelo.GenericResponse;
import itssmt.taller.service.IDetalleService;

@Service
public class DetalleService implements IDetalleService{
	
	@Autowired
	ITDetalleDao detalleDao;

	@Override
	public String save(Detalle detalle) {
		TDetalle tDetalle = new TDetalle();
		
		tDetalle.setCantidad(detalle.getCantidad());
		tDetalle.setFolioDetalle(detalle.getFolioDetalle());
		tDetalle.setPedido_No_pedido(detalle.getPedido_No_pedido());
		tDetalle.setPrecio(detalle.getPrecio());
		tDetalle.setProducto(detalle.getProducto());
		detalleDao.save(tDetalle);
		
		return tDetalle==null?"No se pudieron guardar los detalles":"Se almacenaron los detalles";
	}

	@Override
	public List<Detalle> getAll() {
		
	List<Detalle> listaD = new ArrayList<>();
		
		try {
			
			List<TDetalle> lista  = detalleDao.findAll();
			for (TDetalle d : lista) {
				Detalle detalle = new Detalle();
				detalle.setCantidad(d.getCantidad());
				detalle.setFolioDetalle(d.getFolioDetalle());
			
				detalle.setPedido_No_pedido(d.getPedido_No_pedido());
				detalle.setPrecio(d.getPrecio());
				detalle.setProducto(d.getProducto());
				
				listaD.add(detalle);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return listaD;
	
		
		
	}

	@Override
	public ResponseEntity<GenericResponse<Detalle>> buscarPorId(int id) {
		
		GenericResponse<Detalle> response = new GenericResponse<>();
		
		try {
			TDetalle d = detalleDao.findOne(id);
			Detalle detalle = new Detalle();
			
			detalle.setCantidad(d.getCantidad());
			detalle.setFolioDetalle(d.getFolioDetalle());
		
			detalle.setPedido_No_pedido(d.getPedido_No_pedido());
			detalle.setPrecio(d.getPrecio());
			detalle.setProducto(d.getProducto());
			
			response.setCode(200);
			response.setMessage("Correcto");
			response.setResponse(detalle);
			
		}catch (Exception e) {
			e.printStackTrace();
			response.setCode(500);
			response.setMessage("Error inesperado");
			return new ResponseEntity<GenericResponse<Detalle>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<GenericResponse<Detalle>>(response, HttpStatus.OK);
	}

	

}
