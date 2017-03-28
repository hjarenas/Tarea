package mundo;

import java.io.Serializable;

public class Piloto extends Persona implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5147998115753126194L;
	/**
	 * 
	 * @param nombre
	 * @param appellido
	 */
	public Piloto(String nombre, String appellido){
		this.nombre=nombre;
		this.appelido=appellido;
		this.ocupacion="Piloto";
	}
	@Override
	public String getNombreCompleto() {
		// TODO Auto-generated method stub
		return nombre+ " " + appelido;
	}
	@Override
	public String toString(){
		return getNombreCompleto();
	}
	@Override
	public boolean equals(Object obj){
		Persona otraPersona;
		if ( ! (obj instanceof Pasajero)) return false;
		otraPersona=(Persona) obj;
		if ((this.getNombreCompleto().compareTo(otraPersona.getNombreCompleto()))==0) return true;
		return false;
	}
}
