package mundo;

import java.io.Serializable;

public class Pasajero extends Persona implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1423029481171038542L;
	public Pasajero(String nombre, String appellido, String ocupacion){
		this.nombre=nombre;
		this.appelido=appellido;
		this.ocupacion=ocupacion;
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
