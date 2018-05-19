package itssmt.taller.service;

import itssmt.taller.modelo.Cliente;
import itssmt.taller.modelo.GenericResponse;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;


@Component
public interface IClienteService {

	public String save(Cliente cliente);

	public List<Cliente> getAll();

	public ResponseEntity<GenericResponse<Cliente>> buscarPorId(int id);


}