package dao;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.HibernateException;

import datos.Persona;

public class PersonaDao extends Dao<Persona> {

	// CONSULTA: para traer las personas filtradas por fecha de nacimiento y DNI
	public List<Persona> traerPersonasPorFechaNacimientoYDni(LocalDate fechaNacimiento, int dni)
			throws HibernateException {
		List<Persona> personas = null;
		try {
			iniciaOperacion();
			personas = session
					.createQuery("FROM Persona p WHERE p.fechaNacimiento = :fechaNacimiento AND p.dni = :dni",
							Persona.class)
					.setParameter("fechaNacimiento", fechaNacimiento).setParameter("dni", dni).list();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
		return personas;
	}
}
