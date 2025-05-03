package datos;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Persona {

	private long idPersona;
	private String nombre;
	private String apellido;
	private int dni;
	private LocalDate fechaDeNacimiento;
	private boolean baja;
	private Contacto contacto; // relación 1 a 1
	private Set<Turno> turnos = new HashSet<>(); // relación 1 a muchos
	private Set<Servicio> servicios = new HashSet<>(); // relación muchos a muchos

	public Persona() {
		// Inicializa los sets por seguridad
		this.turnos = new HashSet<>();
		this.servicios = new HashSet<>();
	}

	public Persona(String nombre, String apellido, int dni, LocalDate fechaDeNacimiento) {
		this();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.baja = false; // inicia siempre en false
	}

	// Getters y setters
	public long getIdPersona() {
		return idPersona;
	}

	protected void setIdPersona(long idPersona) {
		this.idPersona = idPersona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public LocalDate getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public boolean isBaja() {
		return baja;
	}

	public void setBaja(boolean baja) {
		this.baja = baja;
	}

	public Contacto getContacto() {
		return contacto;
	}

	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
	}

	public Set<Turno> getTurnos() {
		return turnos;
	}

	public void setTurnos(Set<Turno> turnos) {
		this.turnos = turnos;
	}

	public Set<Servicio> getServicios() {
		return servicios;
	}

	public void setServicios(Set<Servicio> servicios) {
		this.servicios = servicios;
	}

	// Métodos para la relación muchos a muchos
	public boolean agregarServicio(Servicio servicio) {
		return servicios.add(servicio); // evita duplicados
	}

	public boolean eliminarServicio(Servicio servicio) {
		return servicios.remove(servicio);
	}
	
	public void actualizarServicio(String nombre, String apellido, int dni, LocalDate fechaDeNacimiento, boolean baja, Contacto contacto) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.baja = baja;
		this.contacto = contacto;
	}

	// Implementación equals/hashCode basada en idPersona
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return idPersona == other.idPersona;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idPersona);
	}

	@Override
	public String toString() {
		return "Persona [idPersona=" + idPersona + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni
				+ "]";
	}
}
