package datos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

public class Turno {
	private Long idTurno;
	private LocalDate fecha;
	private LocalTime hora;
	private Integer cupoMaximo;
	private EstadoTurno estado;

	private Servicio servicio;
	private Set<ReservaTurno> reservas = new HashSet<>();

	// Constructores
	public Turno(LocalDate fecha, LocalTime hora, Integer cupoMaximo, EstadoTurno estado, Servicio servicio,
			Set<ReservaTurno> reservas) {
		super();
		this.fecha = fecha;
		this.hora = hora;
		this.cupoMaximo = cupoMaximo;
		this.estado = estado;
		this.servicio = servicio;
		this.reservas = new HashSet<>();
	}

	public Turno() {
		super();
	}

	// Getters y Setters

	public Long getIdTurno() {
		return idTurno;
	}

	public void setIdTurno(Long idTurno) {
		this.idTurno = idTurno;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public Integer getCupoMaximo() {
		return cupoMaximo;
	}

	public void setCupoMaximo(Integer cupoMaximo) {
		this.cupoMaximo = cupoMaximo;
	}

	public EstadoTurno getEstado() {
		return estado;
	}

	public void setEstado(EstadoTurno estado) {
		this.estado = estado;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public Set<ReservaTurno> getReservas() {
		return reservas;
	}

	public void setReservas(Set<ReservaTurno> reservas) {
		this.reservas = reservas;
	}

	@Override
	public String toString() {
		return "Turno [idTurno=" + idTurno + ", fecha=" + fecha + ", hora=" + hora + ", cupoMaximo=" + cupoMaximo
				+ ", estado=" + estado + " ]\n";
	}

}
