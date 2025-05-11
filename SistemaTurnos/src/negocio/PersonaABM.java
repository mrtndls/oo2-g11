package negocio;

import java.time.LocalDate;
import java.util.List;

import dao.PersonaDao;
import datos.Persona;

public class PersonaABM {
	private static PersonaABM instancia;
	private PersonaDao dao = new PersonaDao();

	private PersonaABM() {
	}

	public static PersonaABM getInstancia() {
		if (instancia == null) {
			instancia = new PersonaABM();
		}
		return instancia;
	}

	public Persona traerPersonaPorId(long idPersona) {
		return dao.traer(idPersona);
	}

	public List<Persona> traerTodasLasPersonas() {
		return dao.traer();
	}

	public long agregarPersona(Persona p) {
		return dao.agregar(p);
	}

	public void actualizarPersona(Persona p) {
		dao.actualizar(p);
	}

	public void eliminarPersona(Persona p) {
		dao.eliminar(p);
	}

	public List<Persona> traerPersonasPorFechaNacimientoYDni(LocalDate fechaNacimiento, int dni) {
		return dao.traerPersonasPorFechaNacimientoYDni(fechaNacimiento, dni);
	}

}
