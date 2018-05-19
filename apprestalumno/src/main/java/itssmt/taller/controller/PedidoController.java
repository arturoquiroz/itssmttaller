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
import itssmt.taller.modelo.Pedido;
import itssmt.taller.service.IPedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
	
	@Autowired
	IPedidoService pedidoService;
	
	
	@PostMapping(value="/save")
	public String savePedido(@RequestBody Pedido pedido){
			
			return pedidoService.save(pedido);
		
	}
	
	@GetMapping(value="/consultatodos")
	public List<Pedido> traeTodos(){
		
		return pedidoService.getAll();
	}
	
	@GetMapping(value="/consultauno")
	public ResponseEntity<GenericResponse<Pedido>> buscaporid(@RequestParam (value="noPedido", required=true ) int id ){
		
		return pedidoService.buscarPorId(id);
		
	}

}
