package itssmt.taller.serviceimp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import itssmt.taller.dao.ITMaestroDao;
import itssmt.taller.entity.TAlumno;
import itssmt.taller.entity.TMaestro;
import itssmt.taller.modelo.Alumno;
import itssmt.taller.modelo.GenericResponse;
import itssmt.taller.modelo.Profesor;
import itssmt.taller.service.IMaestroService;

@Service
public class MaestroService implements IMaestroService {

	@Autowired
	ITMaestroDao maestroDao;
	
	
	@Override
	public String save(Profesor maestro) {
		
		TMaestro tMaestro = new TMaestro();
		tMaestro.setApellidos(maestro.getApellidos());
		tMaestro.setNombre(maestro.getNombre());
		maestroDao.save(tMaestro);
		
		
		
		
		return tMaestro==null?"No se pudo guardar el profesor":"Se almaceno el profesor";
	}


	@Override
	public List<Profesor> getAll() {
		
		
		
		List<Profesor> listaP = new ArrayList<>();
		try {
			List<TMaestro> lista=maestroDao.findAll();
			
			for(TMaestro m:lista){
				Profesor p = new Profesor();
				p.setApellidos(m.getApellidos());
				p.setIdProfesor(m.getIdMaestro());
				p.setNombre(m.getNombre());
				
				List<Alumno> listAlumno = new ArrayList<>();
				for(TAlumno tAlumno : m.getTAlumnos()){
					Alumno a = new Alumno();
					a.setApellidos(tAlumno.getApellidos());
					a.setIdMaestro(tAlumno.getTMaestro().getIdMaestro());
					a.setNombre(tAlumno.getNombre());
					a.setIdAlumno(tAlumno.getIdAlumno());
					
					listAlumno.add(a);
				}
				
				
				p.setAlumnos(listAlumno);
				listaP.add(p);
				
				
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return listaP;
	}


	@Override
	public ResponseEntity<GenericResponse<Profesor>> buscarPorId(int id) {
		GenericResponse<Profesor> response = new GenericResponse<>();
		
		if(id==4){
			response.setCode(403);
			response.setMessage("Usted no tiene permiso dever esta información, contacte a soporte");
			return new ResponseEntity<GenericResponse<Profesor>>(response,HttpStatus.FORBIDDEN);
		}
			
		
		try {
			TMaestro tMaestro= maestroDao.findOne(id);
			
			Profesor p = new Profesor();
			p.setApellidos(tMaestro.getApellidos());
			p.setIdProfesor(tMaestro.getIdMaestro());
			p.setNombre(tMaestro.getNombre());
			List<Alumno> alumnos = new ArrayList<>();
			for (TAlumno a : tMaestro.getTAlumnos()) {
				Alumno alumno = new Alumno();
				alumno.setApellidos(a.getApellidos());
				alumno.setIdAlumno(a.getIdAlumno());
				alumno.setIdMaestro(a.getTMaestro().getIdMaestro());
				alumno.setNombre(a.getNombre());
				
				
				alumnos.add(alumno);
			}
			
			
			p.setAlumnos(alumnos);
			
			response.setCode(200);
			response.setMessage("Correcto");
			response.setResponse(p);
		} catch (Exception e) {
			e.printStackTrace();
			response.setCode(500);
			response.setMessage("Error inesperado");
			return new ResponseEntity<GenericResponse<Profesor>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		
		
		return new ResponseEntity<GenericResponse<Profesor>>(response, HttpStatus.OK);
	}

}
