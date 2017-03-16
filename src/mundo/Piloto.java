package mundo;

public class Piloto extends Persona{
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
