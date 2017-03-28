package mundo;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Agencia implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4409516234770347006L;
	public Ciudad[] ciudades;
	public Piloto[] pilotos;
	public ArrayList<Vuelo> vuelos;
	public Avion[] aviones;
	
	public Agencia(){
		try{
			FileInputStream fileStr = new FileInputStream("./Extra/serializable.age");
			ObjectInputStream in = new ObjectInputStream(fileStr);
			Agencia prueba= null;
			prueba=(Agencia) in.readObject();
			if(prueba.getCiudades().length>0 && prueba.getCiudades()[0]!=null) cloneAgencia(prueba);
			else defaultAgencia();
			in.close();
			fileStr.close();
		}
		catch (FileNotFoundException e){
			defaultAgencia();
		}
		catch (Exception e){
			System.out.println("There was an exception: " + e.getMessage());
		}
	}
	
	public void reservarAsiento(String ciudadOrigen, String ciudadDestino,String nombre, String apellido, String ocupacion)throws Exception{
		Vuelo vuelo=buscarVuelo(ciudadOrigen, ciudadDestino);
		if (vuelo == null) throw new Exception("Vuelo no encontrado");
		Pasajero p = new Pasajero(nombre,apellido,ocupacion);
		
		vuelo.agregarPasajero(p);
		
	}
	
	public ArrayList<String> getListaDeCiudadesDeOrigen()
	{
		ArrayList<String> ciudadesOrigen= new ArrayList<>();
		for(int i=0;i<vuelos.size();i++){
			ciudadesOrigen.add(vuelos.get(i).getOrigen().toString());
		}
		return ciudadesOrigen;
	}
	public ArrayList<String> getListaDeCiudadesDestino(String origen){
		ArrayList<String> destinos = new ArrayList<>();
		for (Vuelo vuelo : vuelos) {
			if(vuelo.getOrigen().esLaCiudad(origen)) destinos.add(vuelo.getDestino().toString());
		}
		return destinos;
	}
	public int numeroDeAsientosDisponibles(String ciudadOrigen, String ciudadDestino) throws Exception{
		Vuelo vuelo=buscarVuelo(ciudadOrigen, ciudadDestino);
		if (vuelo==null) throw new Exception("Vuelo no encontrado");
		return vuelo.numeroDeAsientosDisponibles();
	}
	private Vuelo buscarVuelo(String ciudadOrigen, String ciudadDestino){
		for(Vuelo vuelo:vuelos){
			if (vuelo.getOrigen().esLaCiudad(ciudadOrigen) && vuelo.getDestino().esLaCiudad(ciudadDestino)) return vuelo;
		}
		return null;
	}
	public void saveFile(){
		try{
			FileOutputStream fileStr = new FileOutputStream("./Extra/serializable.age");
			ObjectOutputStream out = new ObjectOutputStream(fileStr);
			out.writeObject(this);
			out.close();
			fileStr.close();
			
		}
		catch (Exception e){
			
		}
	}
	
	public void cloneAgencia(Agencia clonedFrom){
		ciudades=clonedFrom.getCiudades();
		pilotos=clonedFrom.getPilotos();
		vuelos=clonedFrom.getVuelos();
		aviones=clonedFrom.getAviones();
	}
	
	public void defaultAgencia(){
		ciudades = new Ciudad[4];
		pilotos= new Piloto[3];
		aviones= new Avion[5];
		vuelos= new ArrayList<Vuelo>();
		
		//Agregar las ciudades
		ciudades[0]=new Ciudad("Madrid",30);
		ciudades[1]=new Ciudad("Frankfurt",40);
		ciudades[2]=new Ciudad("Londres",25);
		ciudades[3]=new Ciudad("Roma",30);
		
		//Agregar los pilotos
		pilotos[0]= new Piloto("Juan","Gomez");
		pilotos[1]= new Piloto("Alberto","Moreno");
		pilotos[2]= new Piloto("Camilo","Perez");
		
		//Agregar aviones
		aviones[0]= new Avion();
		aviones[1]= new Avion();
		aviones[2]= new Avion();
		aviones[3]= new Avion();
		aviones[4]= new Avion();
		
		//Agregar vuelos
		for (int i=0;i<4;i++){
			for (int j=0;j<4;j++){
				if (i!=j) vuelos.add(new Vuelo(aviones[j%5],ciudades[i],ciudades[j],pilotos[j%3]));
			}
		}
	}
	
	public Ciudad[] getCiudades() {
		return ciudades;
	}
	public void setCiudades(Ciudad[] ciudades) {
		this.ciudades = ciudades;
	}
	public Piloto[] getPilotos() {
		return pilotos;
	}
	public void setPilotos(Piloto[] pilotos) {
		this.pilotos = pilotos;
	}
	public ArrayList<Vuelo> getVuelos() {
		return vuelos;
	}
	public void setVuelos(ArrayList<Vuelo> vuelos) {
		this.vuelos = vuelos;
	}
	public Avion[] getAviones() {
		return aviones;
	}
	public void setAviones(Avion[] aviones) {
		this.aviones = aviones;
	}
}
