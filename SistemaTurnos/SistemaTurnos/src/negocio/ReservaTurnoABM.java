package negocio;

import java.time.LocalDateTime;
import java.util.List;

import dao.ReservaTurnoDao;
import datos.EstadoReserva;
import datos.Persona;
import datos.ReservaTurno;
import datos.Turno;

public class ReservaTurnoABM {

	private static ReservaTurnoABM instancia;
	private ReservaTurnoDao dao = new ReservaTurnoDao();

	private ReservaTurnoABM() {
	}

	public static ReservaTurnoABM getInstancia() {
		if (instancia == null) {
			instancia = new ReservaTurnoABM();
		}
		return instancia;
	}

	public ReservaTurno traerReservaTurnoPorId(long idReservaTurno) {
		return dao.traer(idReservaTurno);
	}

	public List<ReservaTurno> traerTodasLasReservaTurno() {
		return dao.traer();
	}

	public long agregarReservaTurno(ReservaTurno rt) {
		return dao.agregar(rt);
	}

	public void actualizarReservaTurno(ReservaTurno rt) {
		dao.actualizar(rt);
	}

	public void eliminarReservaTurno(ReservaTurno rt) {
		dao.eliminar(rt);
	}

	public List<ReservaTurno> traerReservasPorPersona(Persona persona) {
		return dao.traerPorPersona(persona);
	}

	public List<ReservaTurno> traerPorTurno(Turno turno) {
		return dao.traerPorTurno(turno);
	}

	public List<ReservaTurno> traerPorEstado(EstadoReserva estado) {
		return dao.traerPorEstado(estado);
	}

	public List<ReservaTurno> traerReservasPorFechaReserva(LocalDateTime desde, LocalDateTime hasta) {
		return dao.traerReservasPorFechaReserva(desde, hasta);
	}
	
	public List<ReservaTurno> traerReservasPorFechaReservaYPersona(LocalDateTime desde, LocalDateTime hasta, Long idPersona) {
	    return dao.traerReservasPorFechaReservaYPersona(desde, hasta, idPersona);
	}


}
