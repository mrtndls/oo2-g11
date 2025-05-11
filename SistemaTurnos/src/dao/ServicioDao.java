package dao;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.HibernateException;

import datos.Servicio;

public class ServicioDao extends Dao<Servicio> {

	// CONSULTA: Traer Servicios creados entre fechas
	public List<Servicio> traerServiciosPorFechaCreacion(LocalDateTime desde, LocalDateTime hasta) {
		try {
			iniciaOperacion();
			return session.createQuery("from Servicio s where s.creadoEn between :desde and :hasta", Servicio.class)
					.setParameter("desde", desde).setParameter("hasta", hasta).list();
		} finally {
			session.close();
		}
	}

	// CONSULTA: para traer los servicios filtrados por fecha de creación y estado
	// activo
	public List<Servicio> traerServiciosPorFechaCreacionYActivo(LocalDateTime desde, LocalDateTime hasta,
			Boolean activo) throws HibernateException {
		List<Servicio> servicios = null;
		try {
			iniciaOperacion();
			servicios = session
					.createQuery("FROM Servicio s WHERE s.creadoEn BETWEEN :desde AND :hasta AND s.activo = :activo",
							Servicio.class)
					.setParameter("desde", desde).setParameter("hasta", hasta).setParameter("activo", activo).list();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
		return servicios;
	}
}
