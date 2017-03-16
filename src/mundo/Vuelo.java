package mundo;

public class Vuelo {
	private Avion aeronave;
	private Pasajero[] asientos;
	private Ciudad origen;
	private Ciudad destino;
	
	public Vuelo(Avion nave,Ciudad pOrigen, Ciudad pDestino){
		aeronave=nave;
		origen=pOrigen;
		destino=pDestino;
		asientos= new Pasajero[aeronave.getCapacidadDeAsientos()];
	}
}
