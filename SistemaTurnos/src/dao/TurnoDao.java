package dao;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.HibernateException;

import datos.Servicio;
import datos.Turno;

public class TurnoDao extends Dao<Turno> {

	// CONSULTA: Traer Turnos entre dos fechas
	public List<Turno> traerTurnosEntreFechas(LocalDate desde, LocalDate hasta) {
		try {
			iniciaOperacion();
			return session.createQuery("from Turno t where t.fecha between :desde and :hasta", Turno.class)
					.setParameter("desde", desde).setParameter("hasta", hasta).list();
		} finally {
			session.close();
		}
	}

	// CONSULTA: Traer Turnos de un Servicio específico entre fechas
	public List<Turno> traerTurnosPorServicioYFecha(Long idServicio, LocalDate desde, LocalDate hasta) {
		try {
			iniciaOperacion();
			return session.createQuery(
					"from Turno t where t.servicio.idServicio = :idServicio and t.fecha between :desde and :hasta",
					Turno.class).setParameter("idServicio", idServicio).setParameter("desde", desde)
					.setParameter("hasta", hasta).list();
		} finally {
			session.close();
		}
	}

	// CONSULTA: Traer Turnos por Fecha y Cupo Máximo
	public List<Turno> traerTurnosPorFechaYCupoMaximo(LocalDate fecha, int cupoMaximo) throws HibernateException {
		List<Turno> lista = null;
		try {
			iniciaOperacion();
			String hql = "WHERE t.fecha = :fecha AND t.cupoMaximo <= :cupoMaximo";
			lista = session.createQuery("from Turno t " + hql, Turno.class).setParameter("fecha", fecha)
					.setParameter("cupoMaximo", cupoMaximo).list();
		} catch (HibernateException he) {
			manejaExcepcion(he);
		} finally {
			session.close();
		}
		return lista;
	}

	// CONSULTA: traer turnos por fecha y estado
	public List<Turno> traerTurnosPorFechaYEstado(LocalDate fecha, String estado) throws HibernateException {
		List<Turno> lista = null;
		try {
			iniciaOperacion();
			String hql = "WHERE t.fecha = :fecha AND t.estado = :estado";
			lista = session.createQuery("from Turno t " + hql, Turno.class).setParameter("fecha", fecha)
					.setParameter("estado", estado).list();
		} catch (HibernateException he) {
			manejaExcepcion(he);
		} finally {
			session.close();
		}
		return lista;
	}

	// CONSULTA: para traer turnos por servicio
	public List<Turno> traerPorServicio(Servicio servicio) throws HibernateException {
		List<Turno> turnos = null;
		try {
			iniciaOperacion();
			turnos = session.createQuery("FROM Turno t WHERE t.servicio = :servicio", Turno.class)
					.setParameter("servicio", servicio).list();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
		return turnos;
	}
}
