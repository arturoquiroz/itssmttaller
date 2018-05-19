package itssmt.taller.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import itssmt.taller.modelo.GenericResponse;
import itssmt.taller.modelo.Profesor;
import itssmt.taller.service.IMaestroService;

@RestController
@RequestMapping("/maestro")
public class MaestroController {

	@Autowired
	IMaestroService maestroService;
	
	@PostMapping(value="/save")
public String saveMaestro(@RequestBody Profesor maestro){
		
		return maestroService.save(maestro);
	
}	
	
	@GetMapping(value="/todos")
	public List<Profesor> traeTodos(){
		
		return maestroService.getAll();
	}
	
	
	@GetMapping(value="/buscar")
	public ResponseEntity<GenericResponse<Profesor>> buscaporid(@RequestParam (value="idProfesor", required=true ) int id ){
		
		return maestroService.buscarPorId(id);
		
	}
	
	
	
}
