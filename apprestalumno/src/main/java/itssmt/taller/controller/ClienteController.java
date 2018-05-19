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

import itssmt.taller.modelo.Cliente;
import itssmt.taller.modelo.GenericResponse;
import itssmt.taller.service.IClienteService;


@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	IClienteService clienteService;
	
	@PostMapping(value="/save")
public String saveCliente(@RequestBody Cliente cliente){
		
		return clienteService.save(cliente);
	
}	
	
	@GetMapping(value="/consultatodos")
	public List<Cliente> traeTodos(){
		
		return clienteService.getAll();
	}
	
	@GetMapping(value="/consultauno")
	public ResponseEntity<GenericResponse<Cliente>> buscaporid(@RequestParam (value="idCliente", required=true ) int id ){
		
		return clienteService.buscarPorId(id);
		
	}
	
	
	
}
