package datos;

import java.time.LocalDateTime;

public class ReservaTurno {
	private Long idReservaTurno;
	private LocalDateTime fechaReserva;
	private EstadoReserva estado;

	private Persona persona;
	private Turno turno;

	// Constructores

	public ReservaTurno(LocalDateTime fechaReserva, EstadoReserva estado, Persona persona, Turno turno) {
		super();
		this.fechaReserva = fechaReserva;
		this.estado = estado;
		this.persona = persona;
		this.turno = turno;
	}

	public ReservaTurno() {
		super();
	}

	// Getters y Setters

	public Long getIdReservaTurno() {
		return idReservaTurno;
	}

	protected void setIdReservaTurno(Long idReservaTurno) {
		this.idReservaTurno = idReservaTurno;
	}

	public LocalDateTime getFechaReserva() {
		return fechaReserva;
	}

	public void setFechaReserva(LocalDateTime fechaReserva) {
		this.fechaReserva = fechaReserva;
	}

	public EstadoReserva getEstado() {
		return estado;
	}

	public void setEstado(EstadoReserva estado) {
		this.estado = estado;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Turno getTurno() {
		return turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

	@Override
	public String toString() {
		return "ReservaTurno [idReservaTurno=" + idReservaTurno + ", fechaReserva=" + fechaReserva + ", estado="
				+ estado + " ]\n";
	}

}
