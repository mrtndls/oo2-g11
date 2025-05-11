package dao;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.HibernateException;

import datos.EstadoReserva;
import datos.Persona;
import datos.ReservaTurno;
import datos.Turno;

public class ReservaTurnoDao extends Dao<ReservaTurno> {

	// Consulta 2: Traer Reservas por Fecha de Reserva y Persona
	public List<ReservaTurno> traerReservasPorFechaReservaYPersona(LocalDateTime desde, LocalDateTime hasta,
			Long idPersona) throws HibernateException {
		List<ReservaTurno> lista = null;
		try {
			iniciaOperacion();
			String hql = "WHERE r.fechaReserva BETWEEN :desde AND :hasta AND r.persona.id = :idPersona";
			lista = session.createQuery("from ReservaTurno r " + hql, ReservaTurno.class).setParameter("desde", desde)
					.setParameter("hasta", hasta).setParameter("idPersona", idPersona).list();
		} catch (HibernateException he) {
			manejaExcepcion(he);
		} finally {
			session.close();
		}
		return lista;
	}

	// CONSULTA: Traer Reservas realizadas entre fechas
	public List<ReservaTurno> traerReservasPorFechaReserva(LocalDateTime desde, LocalDateTime hasta) {
		try {
			iniciaOperacion();
			return session.createQuery("from ReservaTurno r where r.fechaReserva between :desde and :hasta",
					ReservaTurno.class).setParameter("desde", desde).setParameter("hasta", hasta).list();
		} finally {
			session.close();
		}
	}

	// CONSULTA: traer todas las reservas de una persona
	public List<ReservaTurno> traerPorPersona(Persona persona) throws HibernateException {
		String hql = "WHERE r.persona = :persona"; // HQL para traer reservas asociadas a una persona
		List<ReservaTurno> reservas = null;
		try {
			iniciaOperacion();
			// Especificamos el tipo esperado para la consulta
			reservas = session.createQuery("FROM ReservaTurno r " + hql, ReservaTurno.class)
					.setParameter("persona", persona).list();
		} finally {
			session.close();
		}
		return reservas;
	}

	// CONSULTA: para traer todas las reservas de un turno
	public List<ReservaTurno> traerPorTurno(Turno turno) throws HibernateException {
		String hql = "WHERE r.turno = :turno"; // HQL para traer reservas asociadas a un turno
		List<ReservaTurno> reservas = null;
		try {
			iniciaOperacion();
			// Especificamos el tipo esperado para la consulta
			reservas = session.createQuery("FROM ReservaTurno r " + hql, ReservaTurno.class)
					.setParameter("turno", turno).list();
		} finally {
			session.close();
		}
		return reservas;
	}

	// CONSULTA: para traer todas las reservas con un estado específico
	public List<ReservaTurno> traerPorEstado(EstadoReserva estado) throws HibernateException {
		String hql = "WHERE r.estado = :estado"; // HQL para traer reservas con un estado
		List<ReservaTurno> reservas = null;
		try {
			iniciaOperacion();
			// Especificamos el tipo esperado para la consulta
			reservas = session.createQuery("FROM ReservaTurno r " + hql, ReservaTurno.class)
					.setParameter("estado", estado).list();
		} finally {
			session.close();
		}
		return reservas;
	}

}
