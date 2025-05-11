package negocio;

import java.time.LocalDateTime;
import java.util.List;

import dao.ServicioDao;
import datos.Servicio;

public class ServicioABM {

	private static ServicioABM instancia;
	private ServicioDao dao = new ServicioDao();

	private ServicioABM() {
	}

	public static ServicioABM getInstancia() {
		if (instancia == null) {
			instancia = new ServicioABM();
		}
		return instancia;
	}

	public Servicio traerServicioPorId(long idServicio) {
		return dao.traer(idServicio);
	}

	public List<Servicio> traerTodosLosServicios() {
		return dao.traer();
	}

	public long agregarServicio(Servicio s) {
		return dao.agregar(s);
	}

	public void actualizarServicio(Servicio s) {
		dao.actualizar(s);
	}

	public void eliminarServicio(Servicio s) {
		dao.eliminar(s);
	}
	
	public List<Servicio> traerServiciosPorFechaCreacion(LocalDateTime desde, LocalDateTime hasta) {
		return dao.traerServiciosPorFechaCreacion(desde, hasta);
	}
	
	public List<Servicio> traerServiciosPorFechaCreacionYActivo(LocalDateTime desde, LocalDateTime hasta, Boolean activo) {
	    return dao.traerServiciosPorFechaCreacionYActivo(desde, hasta, activo);
	}

}
