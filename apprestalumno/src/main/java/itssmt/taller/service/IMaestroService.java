package itssmt.taller.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import itssmt.taller.modelo.GenericResponse;
import itssmt.taller.modelo.Profesor;

@Component
public interface IMaestroService {

	public String save(Profesor maestro);

	public List<Profesor> getAll();

	public ResponseEntity<GenericResponse<Profesor>> buscarPorId(int id);

}
