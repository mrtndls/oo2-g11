package datos;

public class Contacto {

	private long idContacto;
	private String email;
	private String movil;
	private String fijo;
	private Persona persona;

	public Contacto() {
	}

	public Contacto(String email, String movil, String fijo, Persona persona) {
		this.email = email;
		this.movil = movil;
		this.fijo = fijo;
		this.persona = persona;
	}

	public long getIdContacto() {
		return idContacto;
	}

	protected void setIdContacto(long idContacto) {
		this.idContacto = idContacto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMovil() {
		return movil;
	}

	public void setMovil(String movil) {
		this.movil = movil;
	}

	public String getFijo() {
		return fijo;
	}

	public void setFijo(String fijo) {
		this.fijo = fijo;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	@Override
	public String toString() {
		return "Contacto [idContacto=" + idContacto + ", email=" + email + ", movil=" + movil + ", fijo=" + fijo + "]";
	}

}
