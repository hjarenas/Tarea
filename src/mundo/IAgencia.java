package mundo;

import java.util.ArrayList;

public interface IAgencia {
	public void reservarAsiento(String ciudadOrigen, String ciudadDestino,String nombre, String apellido, String ocupacion)throws Exception;
	public ArrayList<String> getListaDeCiudadesDeOrigen();
	public ArrayList<String> getListaDeCiudadesDestino(String origen);
	public int numeroDeAsientosDisponibles(String ciudadOrigen, String ciudadDestino) throws Exception;
}
