package itssmt.taller.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the t_maestro database table.
 * 
 */
@Entity
@Table(name="t_maestro")
@NamedQuery(name="TMaestro.findAll", query="SELECT t FROM TMaestro t")
public class TMaestro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idMaestro;

	private String apellidos;

	private String nombre;

	//bi-directional many-to-one association to TAlumno
	@OneToMany(mappedBy="TMaestro")
	private List<TAlumno> TAlumnos;

	public TMaestro() {
	}

	public int getIdMaestro() {
		return this.idMaestro;
	}

	public void setIdMaestro(int idMaestro) {
		this.idMaestro = idMaestro;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<TAlumno> getTAlumnos() {
		return this.TAlumnos;
	}

	public void setTAlumnos(List<TAlumno> TAlumnos) {
		this.TAlumnos = TAlumnos;
	}

	public TAlumno addTAlumno(TAlumno TAlumno) {
		getTAlumnos().add(TAlumno);
		TAlumno.setTMaestro(this);

		return TAlumno;
	}

	public TAlumno removeTAlumno(TAlumno TAlumno) {
		getTAlumnos().remove(TAlumno);
		TAlumno.setTMaestro(null);

		return TAlumno;
	}

}