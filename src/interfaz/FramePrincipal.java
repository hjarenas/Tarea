package interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import mundo.Agencia;

public class FramePrincipal extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3679572833971128693L;
	private Agencia agencia;
	private JPanel mainPanel;
	private JComboBox<String> ciudadesOrigen;
	private JComboBox<String> ciudadesDestino;
	private JTextField nombre;
	private JTextField apellido;
	private JTextField ocupacion;
	private JButton aceptar;
	private JButton cancelar;
	
	public FramePrincipal(){
		agencia=new Agencia();
		mainPanel=new JPanel();
		
		ciudadesOrigen=new JComboBox<String>();
		ciudadesDestino=new JComboBox<String>();
		nombre=new JTextField();
		apellido=new JTextField();
		ocupacion=new JTextField();
		aceptar=new JButton("Aceptar");
		cancelar= new JButton("Cancelar");

		//Llenar el primer combo box
		ArrayList<String> ciudades;
		ciudades=agencia.getListaDeCiudadesDeOrigen();
		for (String ciudad : ciudades) {
			ciudadesOrigen.addItem(ciudad);
		}
		
		//Llenar  el segundo
		actualizarDestinos();
		
		dealWithEvents();
	}
	public void dealWithEvents(){
		//Actualizar el sedundo si el usuario cambia algo en el primero
		ciudadesOrigen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				actualizarDestinos();
			}
		});
		
		cancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		aceptar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					if(nombre.getText().length()==0 || apellido.getText().length()==0 || ocupacion.getText().length()==0){
						JOptionPane.showMessageDialog(mainPanel,"Por favor llenar todos los campos para reservar un vuelo");
						return;
					}
					agencia.reservarAsiento((String) ciudadesOrigen.getSelectedItem(), (String) ciudadesDestino.getSelectedItem(), nombre.getText(), apellido.getText(), ocupacion.getText());
					
					JOptionPane.showMessageDialog(mainPanel,"El vuelo fue reservado con exito!");
				}
				catch(Exception ex){
					JOptionPane.showMessageDialog(mainPanel,ex.getMessage());
				}
			}
		});
	}
	
	public void actualizarDestinos(){
		ArrayList<String> ciudades;
		ciudadesDestino.removeAllItems();
		
		ciudades=agencia.getListaDeCiudadesDestino((String) ciudadesOrigen.getSelectedItem()) ;
		for (String ciudad : ciudades) {
			ciudadesDestino.addItem(ciudad);
		}
	}
	public void startProgram()
	{
		setSize (800,300);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setContentPane(mainPanel);
		mainPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		mainPanel.setLayout(new GridLayout(6, 2));
		
		
		mainPanel.add(new JLabel("Ciudad de Origen"));
		mainPanel.add(ciudadesOrigen);
		mainPanel.add(new JLabel("Ciudad de Destino"));
		mainPanel.add(ciudadesDestino);
		mainPanel.add(new JLabel("Nombre"));
		mainPanel.add(nombre);
		mainPanel.add(new JLabel("Apellido"));
		mainPanel.add(apellido);
		mainPanel.add(new JLabel("Ocupacion"));
		mainPanel.add(ocupacion);
		mainPanel.add(aceptar);
		mainPanel.add(cancelar);
		
	}
	
	@Override
	public void dispose(){
		agencia.saveFile();
		System.exit(DISPOSE_ON_CLOSE);
	}

	public static void main(String[] args){
		FramePrincipal fp = new FramePrincipal();
		fp.startProgram();
		fp.setVisible(true);
	}
}
