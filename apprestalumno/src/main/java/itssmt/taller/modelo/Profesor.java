package itssmt.taller.modelo;

import java.util.List;

public class Profesor {
	
private int idProfesor;
private String nombre;
private String apellidos;
private List<Alumno> alumnos;


public List<Alumno> getAlumnos() {
	return alumnos;
}
public void setAlumnos(List<Alumno> alumnos) {
	this.alumnos = alumnos;
}
public int getIdProfesor() {
	return idProfesor;
}
public void setIdProfesor(int idProfesor) {
	this.idProfesor = idProfesor;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getApellidos() {
	return apellidos;
}
public void setApellidos(String apellidos) {
	this.apellidos = apellidos;
}

}
