package negocio;

import java.time.LocalDate;
import java.util.List;

import datos.Servicio;
import datos.Turno;
import dao.TurnoDao;

public class TurnoABM {

	private static TurnoABM instancia;
	private TurnoDao dao = new TurnoDao();

	private TurnoABM() {
	}

	public static TurnoABM getInstancia() {
		if (instancia == null) {
			instancia = new TurnoABM();
		}
		return instancia;
	}

	public Turno traerTurnoPorId(long idTurno) {
		return dao.traer(idTurno);
	}

	public List<Turno> traerTodosLosTurnos() {
		return dao.traer();
	}

	public long agregarTurno(Turno t) {
		return dao.agregar(t);
	}

	public void actualizarTurno(Turno t) {
		dao.actualizar(t);
	}

	public void eliminarTurno(Turno t) {
		dao.eliminar(t);
	}

	public List<Turno> traerPorServicio(Servicio servicio) {
		return dao.traerPorServicio(servicio);
	}

	public List<Turno> traerTurnosEntreFechas(LocalDate desde, LocalDate hasta) {
		return dao.traerTurnosEntreFechas(desde, hasta);
	}

	public List<Turno> traerTurnosPorServicioYFecha(Long idServicio, LocalDate desde, LocalDate hasta) {
		return dao.traerTurnosPorServicioYFecha(idServicio, desde, hasta);
	}

	public List<Turno> traerTurnosPorFechaYCupoMaximo(LocalDate fecha, int cupoMaximo) {
	    return dao.traerTurnosPorFechaYCupoMaximo(fecha, cupoMaximo);
	}


}
