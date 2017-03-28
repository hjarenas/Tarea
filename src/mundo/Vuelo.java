package mundo;

import java.io.Serializable;

public class Vuelo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6978357253636139112L;
	private Avion aeronave;
	private Pasajero[] asientos;
	private Ciudad origen;
	private Ciudad destino;
	private Piloto piloto;
	
	public Vuelo(Avion nave,Ciudad pOrigen, Ciudad pDestino, Piloto pPiloto){
		aeronave=nave;
		origen=pOrigen;
		destino=pDestino;
		piloto=pPiloto;
		asientos= new Pasajero[aeronave.getCapacidadDeAsientos()];
	}
	
	public void agregarPasajero(Pasajero pasajero) throws Exception{
		if (asientos.length>=aeronave.getCapacidadDeAsientos()) throw new Exception ("El vuelo ya esta lleno");
		
		asientos[asientos.length]=pasajero;
	}
	
	public Avion getAeronave() {
		return aeronave;
	}

	public void setAeronave(Avion aeronave) {
		this.aeronave = aeronave;
	}

	public Pasajero[] getAsientos() {
		return asientos;
	}

	public void setAsientos(Pasajero[] asientos) {
		this.asientos = asientos;
	}

	public Ciudad getOrigen() {
		return origen;
	}

	public void setOrigen(Ciudad origen) {
		this.origen = origen;
	}

	public Ciudad getDestino() {
		return destino;
	}

	public void setDestino(Ciudad destino) {
		this.destino = destino;
	}

	public Piloto getPiloto() {
		return piloto;
	}

	public void setPiloto(Piloto piloto) {
		this.piloto = piloto;
	}

	@Override
	public String toString(){
		return aeronave.toString()+asientos.toString()+origen.toString()+destino.toString()+piloto.toString();
	}
}
