package itssmt.taller.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import itssmt.taller.modelo.GenericResponse;
import itssmt.taller.modelo.Pedido;

public interface IPedidoService {

	String save(Pedido pedido);

	List<Pedido> getAll();

	ResponseEntity<GenericResponse<Pedido>> buscarPorId(int id);

}
