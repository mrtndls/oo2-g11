package datos;

import java.time.LocalDate;

public abstract class Turno {

	protected long idTurno;
	protected LocalDate fecha;
	protected Persona persona;

	public Turno() {
	}

	public Turno(LocalDate fecha, Persona persona) {
		super();
		this.fecha = fecha;
		this.persona = persona;
	}

	public long getIdTurno() {
		return idTurno;
	}

	protected void setIdTurno(long idTurno) {
		this.idTurno = idTurno;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	@Override
	public String toString() {
		return "Turno [idTurno=" + idTurno + ", fecha=" + fecha + ", idPersona="
				+ (persona != null ? persona.getIdPersona() : "null") + "]";
	}

}
