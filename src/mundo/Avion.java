package mundo;

public class Avion {
	private final static int NUMERO_DE_ASIENTOS = 100;
	private final static double COMBUSTIBLE = 200.0;
	
	
	private int capacidadDeAsientos;
	private double capacidadDeCombustible;
	
	private double combustibleRestante;
	
	/**
	 *  Clase constructora del avion
	 * @param asientos - Numero de asientos que tiene disponible
	 * @param combustible - Cuanto combustible se puede almacenar en el avion
	 */
	public Avion (int asientos,double combustible){
		capacidadDeAsientos=asientos;
		capacidadDeCombustible=combustible;
	}

	/**
	 * Clase constructora con el numero default de asientos
	 */
	public Avion (){
		this(NUMERO_DE_ASIENTOS,COMBUSTIBLE);
	}	
	public double getCombustibleRestante() {
		return combustibleRestante;
	}

	public void llenarTanque(double combustibleRestante) {
		if(combustibleRestante>capacidadDeCombustible) combustibleRestante=capacidadDeCombustible;
		this.combustibleRestante = combustibleRestante;
	}

	public int getCapacidadDeAsientos() {
		return capacidadDeAsientos;
	}

	public double getCapacidadDeCombustible() {
		return capacidadDeCombustible;
	}

}
