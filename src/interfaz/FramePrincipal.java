package interfaz;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import mundo.Agencia;

public class FramePrincipal extends JFrame{
	private Agencia agencia;
	private JPanel mainPanel;
	public FramePrincipal(){
		agencia=new Agencia();
		mainPanel=new JPanel();
		
	}
	public void startProgram()
	{
		setSize (300,300);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setContentPane(mainPanel);
		mainPanel.add(new JLabel("Test"));
		
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
