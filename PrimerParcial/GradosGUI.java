import javax.swing.*;
import java.awt.GridLayout;

public class GradosGUI extends JFrame{
	
	private JTextField 	tfGrados;
	private JButton 	bCalcular, bSalir;
	
	
	public GradosGUI(){
		super("Conversión de Grados");
		//1. Crear objetos de los atributos o variables de la clase.
		tfGrados  = new JTextField();
		bCalcular = new JButton("G. Centigrados a G.Farenheit");
		bSalir 	  = new JButton("Exit");
		
		//2. Definir el Layout del JFrame.
		setLayout(new GridLayout(2,2));
		
		//3. Poner los objetos de los atributos en el JFrame.
		add(new JLabel("Grados a convertir:"));
		add(tfGrados);
		add(bCalcular);
		add(bSalir);
		
		//4. Hacer Visible el JFrame.		
		setSize(600,400);
		setVisible(true);
	}
	
	public static void main(String args[]){
		GradosGUI grados = new GradosGUI();
	}	
}