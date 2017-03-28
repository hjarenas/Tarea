package mundo;

import java.io.Serializable;

public class Ciudad implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8413931871268820003L;
	private String nombre;
	private int vuelos;
	
	public Ciudad (String sNombre,int nVuelos){
		nombre=sNombre;
		vuelos=nVuelos;
	}
	
	public String toString(){
		return nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getVuelos() {
		return vuelos;
	}

	public void setVuelos(int vuelos) {
		this.vuelos = vuelos;
	}
	public boolean esLaCiudad (String sNombre){
		if(nombre.compareTo(sNombre) ==0) return true;
		return false;
	}
}
