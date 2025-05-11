package datos;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Persona {
	private Long idPersona;
	private String nombre;
	private String apellido;
	private int dni;
	private String email;
	private String telefono;
	private LocalDate fechaNacimiento;

	private Set<ReservaTurno> reservas = new HashSet<>();

	// Constructores

	public Persona() {
		super();
	}

	public Persona(String nombre, String apellido, int dni, String email, String telefono, LocalDate fechaNacimiento,
			Set<ReservaTurno> reservas) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.email = email;
		this.telefono = telefono;
		this.fechaNacimiento = fechaNacimiento;
		this.reservas = new HashSet<>();
	}

	// Getters y Setters

	public Long getIdPersona() {
		return idPersona;
	}

	protected void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}

	public String getNombre() {
		return nombre;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Set<ReservaTurno> getReservas() {
		return reservas;
	}

	public void setReservas(Set<ReservaTurno> reservas) {
		this.reservas = reservas;
	}

	// tostring
	@Override
	public String toString() {
		return "Persona [idPersona=" + idPersona + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni
				+ ", email=" + email + ", telefono=" + telefono + ", fechaNacimiento=" + fechaNacimiento + "]\n";
	}

}
