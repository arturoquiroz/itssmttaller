package itssmt.taller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import itssmt.taller.modelo.Alumno;
import itssmt.taller.modelo.GenericResponse;
import itssmt.taller.modelo.Profesor;
import itssmt.taller.service.IAlumnoService;

@RestController
@RequestMapping("/rest")
public class AlumnoController {
	
	@Autowired
	IAlumnoService alumnoService;

	@GetMapping(value="/test")
	public String test(){
		return "hello world!";
	}
	
	
	@GetMapping(value="/respuesta")
	public String respuesta(@RequestParam(value="nombre",required=true) String tuNombre){
		
		return "hello  "+tuNombre;
	}
	
	
	
	@GetMapping(value="/respuesta2")
	public String respuesta2sdfsdf(@RequestParam(value="nombre",required=true) String tuNombre,
			@RequestParam(value="apellido",required=false) String tuApellido){
		
		String apellido=  tuApellido==null?"sin apellido":tuApellido;
		
		return "hello  "+tuNombre+" "+apellido;
	}
	
	
	@GetMapping(value="/validaApellido")
	public String validaApellidoProf(@RequestParam(value="nombre",required=false) String tuNombre,
			@RequestParam(value="apellido",required=true) String tuApellido, @RequestHeader(value="Titulo", required=true) String tuTitulo){
		
	
		
		if(tuApellido.equalsIgnoreCase("Gonzalez")){
			
			return "Bienvenido "+tuTitulo +" "+tuApellido;
			
		}else{
			return "No se encuentra en la base de datos "+ tuTitulo + " " + tuApellido;
		}
		
		
	}
	
	
	
	
	
	@PostMapping(value="/saveAlumno")
	public GenericResponse<Alumno> saveAlumno(@RequestBody Alumno alumno){
		GenericResponse<Alumno> response = new GenericResponse<>();
		
		
		response.setCode(200);
		response.setMessage("El alumno "+alumno.getNombre()+ " se guardo correctamente.");
		response.setResponse(alumno);
		
		return response;
		
	}
	
	@PostMapping(value="/saveProfesor")
	public GenericResponse<Profesor> saveProfesor(@RequestBody Profesor profesor){
		GenericResponse<Profesor> response = new GenericResponse<>();
		
		
		response.setCode(200);
		response.setMessage("El profesor "+profesor.getNombre()+ " se guardo correctamente.");
		response.setResponse(profesor);
		
		return response;
		
	}
	

	
	
	
	
	
	
	
	
	
	
}
