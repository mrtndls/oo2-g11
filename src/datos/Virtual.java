package datos;

import java.time.LocalDate;

public class Virtual extends Turno {

	private String link;

	public Virtual() {
		super();
	}

	public Virtual(LocalDate fecha, Persona persona, String link) {
		super(fecha, persona);
		this.link = link;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Override
	public String toString() {
		return "Virtual [" + super.toString() + ", link=" + link + "]";
	}

}
