package datos;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Servicio {
	private Long idServicio;
	private String nombre;
	private String descripcion;
	private Boolean activo;
	private LocalDateTime creadoEn;
	private LocalDateTime actualizadoEn;

	private Set<Turno> turnos = new HashSet<>();

	// Constructores

	public Servicio(String nombre, String descripcion, Boolean activo, LocalDateTime creadoEn,
			LocalDateTime actualizadoEn, Set<Turno> turnos) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.activo = activo;
		this.creadoEn = creadoEn;
		this.actualizadoEn = actualizadoEn;
		this.turnos = new HashSet<>();
	}

	public Servicio() {
		super();
	}

	// Getters y Setters

	public Long getIdServicio() {
		return idServicio;
	}

	protected void setIdServicio(Long idServicio) {
		this.idServicio = idServicio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public LocalDateTime getCreadoEn() {
		return creadoEn;
	}

	public void setCreadoEn(LocalDateTime creadoEn) {
		this.creadoEn = creadoEn;
	}

	public LocalDateTime getActualizadoEn() {
		return actualizadoEn;
	}

	public void setActualizadoEn(LocalDateTime actualizadoEn) {
		this.actualizadoEn = actualizadoEn;
	}

	public Set<Turno> getTurnos() {
		return turnos;
	}

	public void setTurnos(Set<Turno> turnos) {
		this.turnos = turnos;
	}

	@Override
	public String toString() {
		return "Servicio [idServicio=" + idServicio + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", activo=" + activo + ", creadoEn=" + creadoEn + ", actualizadoEn=" + actualizadoEn + " ]\n";
	}

}
