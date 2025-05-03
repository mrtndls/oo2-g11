package datos;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public class Servicio {

	private long idServicio;
	private String nombre;
	private String descripcion;
	private Set<Persona> personas = new HashSet<>();

	public Servicio() {
	}

	public Servicio(String nombre, String descripcion, Set<Persona> personas) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.personas = personas;
	}

	public long getIdServicio() {
		return idServicio;
	}

	protected void setIdServicio(long idServicio) {
		this.idServicio = idServicio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Set<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(Set<Persona> personas) {
		this.personas = personas;
	}

	// Método para agregar una persona si no existe ya
	public boolean agregarPersona(Persona persona) {
		return personas.add(persona);
	}

	// Método para eliminar una persona por equals()
	public boolean eliminarPersona(Persona persona) {
		Persona borrar = null;
		boolean eliminar = false;
		Iterator<Persona> it = personas.iterator();
		while (it.hasNext() && borrar == null) {
			Persona p = it.next();
			if (p.equals(persona))
				borrar = p;
		}
		if (borrar != null) {
			eliminar = personas.remove(borrar);
		}
		return eliminar;
	}

	// equals/hashCode basado en idServicio
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Servicio other = (Servicio) obj;
		return idServicio == other.idServicio;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idServicio);
	}

	@Override
	public String toString() {
		return "Servicio [idServicio=" + idServicio + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}
}
