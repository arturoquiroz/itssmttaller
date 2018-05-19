package itssmt.taller.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import itssmt.taller.modelo.Detalle;
import itssmt.taller.modelo.GenericResponse;

public interface IDetalleService {
	
	String save(Detalle detalle);

	List<Detalle> getAll();

	ResponseEntity<GenericResponse<Detalle>> buscarPorId(int id);

}
