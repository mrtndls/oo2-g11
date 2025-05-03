package datos;

import java.time.LocalDate;

public class Presencial extends Turno {

	private String ubicacion;

	public Presencial() {
		super();
	}

	public Presencial(LocalDate fecha, Persona persona, String ubicacion) {
		super(fecha, persona);
		this.ubicacion = ubicacion;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	@Override
	public String toString() {
		return "Presencial [" + super.toString() + ", ubicacion=" + ubicacion + "]";
	}
}
