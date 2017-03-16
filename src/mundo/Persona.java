package mundo;

public abstract class Persona {
	protected String nombre;
	protected String appelido;
	protected String ocupacion;
	
	public abstract String getNombreCompleto();
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getAppelido() {
		return appelido;
	}
	public void setAppelido(String appelido) {
		this.appelido = appelido;
	}
	public String getOcupacion() {
		return ocupacion;
	}
	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}
	
}
