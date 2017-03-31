package mundo;

import java.io.Serializable;

public class Vuelo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6978357253636139112L;
	private Avion aeronave;
	private Pasajero[] asientosReservados;
	private int numAsientosReservados;
	private Ciudad origen;
	private Ciudad destino;
	private Piloto piloto;
	
	public Vuelo(Avion nave,Ciudad pOrigen, Ciudad pDestino, Piloto pPiloto){
		aeronave=nave;
		origen=pOrigen;
		destino=pDestino;
		piloto=pPiloto;
		asientosReservados= new Pasajero[aeronave.getCapacidadDeAsientos()];
	}
	
	public void agregarPasajero(Pasajero pasajero) throws Exception{
		if (numAsientosReservados>=aeronave.getCapacidadDeAsientos()) throw new Exception ("El vuelo ya esta lleno");
		
		asientosReservados[numAsientosReservados++]=pasajero;
	}
	public int numeroDeAsientosDisponibles(){
		return aeronave.getCapacidadDeAsientos()-asientosReservados.length;
	}
	
	public Avion getAeronave() {
		return aeronave;
	}

	public void setAeronave(Avion aeronave) {
		this.aeronave = aeronave;
	}

	public Pasajero[] getAsientos() {
		return asientosReservados;
	}

	public void setAsientos(Pasajero[] asientos) {
		this.asientosReservados = asientos;
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
		return aeronave.toString()+asientosReservados.toString()+origen.toString()+destino.toString()+piloto.toString();
	}
}
