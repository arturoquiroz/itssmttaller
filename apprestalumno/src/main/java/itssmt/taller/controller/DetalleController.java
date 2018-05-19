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

import itssmt.taller.modelo.Detalle;
import itssmt.taller.modelo.GenericResponse;
import itssmt.taller.service.IDetalleService;

@RestController
@RequestMapping("/detalles")
public class DetalleController {

	@Autowired
	IDetalleService detalleService;
	
	@PostMapping(value="/save")
	public String saveDetalle(@RequestBody Detalle detalle){
			
			return detalleService.save(detalle);
		
	}
	
	@GetMapping(value="/consultatodos")
	public List<Detalle> traeTodos(){
		
		return detalleService.getAll();
	}
	
	@GetMapping(value="/consultauno")
	public ResponseEntity<GenericResponse<Detalle>> buscaporid(@RequestParam (value="folioDetalle", required=true ) int id ){
		
		return detalleService.buscarPorId(id);
		
	}
}
