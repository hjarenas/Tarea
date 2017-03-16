package interfaz;

import mundo.Agencia;

public class FramePrincipal {
	private Agencia agencia;
	
	public FramePrincipal(){
		agencia=new Agencia();
	}

	public static void main(int[] args){
		FramePrincipal fp = new FramePrincipal();
	}
}
