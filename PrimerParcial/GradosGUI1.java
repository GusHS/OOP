import javax.swing.*;
import java.awt.*;

public class GradosGUI1 extends JFrame{
	
	private JTextField 	tfGrados;
	private JButton 	bCalcular, bSalir;
	private JPanel 		panel1, panel2;
	private JTextArea 	taDatos;
	
	public GradosGUI1(){
		super("Conversión de Grados");
		//1. Crear objetos de los atributos o variables de la clase.
		tfGrados  	= new JTextField();
		bCalcular 	= new JButton("G. Centigrados a G.Farenheit");
		bSalir 	  	= new JButton("Exit");
		panel1 		= new JPanel();
		panel2 		= new JPanel();
		taDatos 	= new JTextArea(10,30);
		//2. Definir el Layout de los JPanels.
		panel1.setLayout(new GridLayout(2,2));
		panel2.setLayout(new FlowLayout());
		//3. Poner los objetos de los atributos en el JFrame.
		panel1.add(new JLabel("Grados a convertir:"));
		panel1.add(tfGrados);
		panel1.add(bCalcular);
		panel1.add(bSalir);
		
		panel2.add(panel1);
		panel2.add(new JScrollPane(taDatos));
		
		//4.Añadir panel2 en el JFame y Hacer Visible el JFrame.		
		add(panel2);
		setSize(600,400);
		setVisible(true);
	}
	
	public static void main(String args[]){
		GradosGUI1 grados = new GradosGUI1();
	}	
}