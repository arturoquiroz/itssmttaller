package itssmt.taller.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the t_alumno database table.
 * 
 */
@Entity
@Table(name="t_alumno")
@NamedQuery(name="TAlumno.findAll", query="SELECT t FROM TAlumno t")
public class TAlumno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idAlumno;

	private String apellidos;

	private String nombre;

	//bi-directional many-to-one association to TMaestro
	@ManyToOne
	@JoinColumn(name="t_maestro_idMaestro")
	private TMaestro TMaestro;

	public TAlumno() {
	}

	public int getIdAlumno() {
		return this.idAlumno;
	}

	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
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

	public TMaestro getTMaestro() {
		return this.TMaestro;
	}

	public void setTMaestro(TMaestro TMaestro) {
		this.TMaestro = TMaestro;
	}

}