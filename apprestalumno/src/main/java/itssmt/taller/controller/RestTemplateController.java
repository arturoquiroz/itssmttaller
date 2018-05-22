package itssmt.taller.controller;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/template")
public class RestTemplateController {

	RestTemplate restTemplate = new RestTemplate(); 
	
	//@RequestMapping(value="/products", method = RequestMethod.GET)
	@GetMapping(value="/products")
	public String getProductsByTemplate() {
		System.out.println("Encontro el metodo");
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		return restTemplate.exchange("http://192.168.1.71:8090/cliente/consultatodos", HttpMethod.GET, entity, String.class).getBody();
	}
	/* 
	 * Metodo creado para consultar mediante el id o folio, el estado de un pedido y obtener su valor en
	 * el body de la respuesta*/
	@GetMapping(value="/factura")
	public String getEstadoDeFactura(int id) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		return restTemplate.exchange("http://192.168.1.71:8090/estadodefactura?id="+id, HttpMethod.GET, entity, String.class).getBody();
	}
}
